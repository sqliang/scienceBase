package com.science.dao;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.jms.Message;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oracle.sql.CLOB;
import oracle.sql.NCLOB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;
import com.science.util.DateFormatUtil;
import com.science.util.string.ClobUtil;

/**
 *改进：
 *1.将resultset封装为json格式返回，这样有利于resultset和statement的关闭；
 *2.将resultset和statement的关闭置于finally块中，确保他们的关闭;
 *3.连接池的close()方法把连接返回到连接池而不是真正地关闭它，所以使用完connection后应手动释放，即调用close方法
 * @author modified by wdl
 *
 */
@Component
public class Jdao {
	@Autowired
	private DruidDataSource c3p0DataSource;

	public Connection getConnection() {
		Connection connection ;
		try {
			connection = c3p0DataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取连接失败：" + e.getMessage(), e);
		}
		return connection;
	}

	public JSONArray getResultJsonArray(String sql, Serializable... values) {
		Connection connection = null ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = this.getConnection();
			ps = connection.prepareStatement(sql);
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					ps.setObject(i + 1, values[i]);
				}
			}
			
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			//将结果集内容经过处理保存在jsonArray中，并返回
			JSONArray resultJsonArray = new JSONArray();
			while (rs.next()) {
				JSONObject jsonObject = new JSONObject();
				for(int i = 1; i <= colCount; i++){
					if(rs.getObject(i) instanceof Date){
						jsonObject.put(metaData.getColumnLabel(i).toLowerCase(), DateFormatUtil.formatYmdHms((Date)rs.getObject(i)));
					}else if(rs.getObject(i) instanceof CLOB){
						jsonObject.put(metaData.getColumnLabel(i).toLowerCase(), ClobUtil.ClobToString((CLOB)rs.getObject(i)));
					}else if(rs.getObject(i) instanceof NCLOB){
						jsonObject.put(metaData.getColumnLabel(i).toLowerCase(), ClobUtil.ClobToString((NCLOB)rs.getObject(i)));
					}else{
						jsonObject.put(metaData.getColumnLabel(i).toLowerCase(), rs.getObject(i));
					}
				}
				resultJsonArray.add(jsonObject);
			}
			return resultJsonArray;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取结果集失败:" + e.getMessage(), e);
		} finally {	//在finally块中释放资源，无论是否有异常发生，释放动作都可以进行
			this.close(rs , ps, connection);
		}
	}

	/**
	 * add by wdl 实现对表的操作，如：增删改，只有一条操作语句，不需考虑事务
	 * @param sql
	 * @param values
	 */
	public void operateTable(String sql, Serializable... values) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = this.getConnection();
			ps = connection.prepareStatement(sql);
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					ps.setObject(i + 1, values[i]);
				}
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改表失败:" + e.getMessage(), e);
		} finally {
			this.close(null, ps, connection);
		}
	}

	//oracle关键字ROWNUM显示行号，只有使用别名的时候才能使用大于号
	public JSONArray getResultJsonArrayByPage(String sql, int start, int limit,
			Serializable... values) {
		String pageSql = "SELECT * FROM (SELECT ROWNUM RN,TEMPTABLE_.* FROM ("
				+ sql + ") TEMPTABLE_ WHERE ROWNUM <" + (start + limit + 1)
				+ ") WHERE RN >" + start;
		System.out.println(pageSql);
		return this.getResultJsonArray(pageSql, values);
	}
	
	/**
	 * 
	 * @param sql
	 * @return 以字符串形式返回第一行第一列的值
	 */
	public String simpleSQL(String sql,Serializable... values) {
		String colValue = null ;
		JSONArray resultJsonArray = this.getResultJsonArray(sql,values);
		JSONObject resultJsonObject = resultJsonArray.getJSONObject(0);
		//获取jsonobject中值集合的迭代器
		Iterator<?> iterator = resultJsonObject.values().iterator();
		if(iterator.hasNext()){
			colValue = iterator.next().toString();
		}
		return colValue;
	}
	
	/**
	 * 
	 * @param sql
	 * @return 以字符串集合形式返回第一列的值
	 */
	public List<String> simpleSQLAsList(String sql,Serializable... values) {
		List<String> colValues = new ArrayList<String>();
		JSONArray resultJsonArray = this.getResultJsonArray(sql,values);
		if(resultJsonArray!=null){
			for(int i=0;i<resultJsonArray.size();i++){
				JSONObject resultJsonObject = resultJsonArray.getJSONObject(i);
				Iterator<?> iterator = resultJsonObject.values().iterator();
				if(iterator.hasNext()){
					colValues.add(iterator.next().toString());
				}
			}
		}
		return colValues;
	}

	/**
	 * 通过sql 语句获得分页总数
	 * @param sql sql语句
	 * @return
	 * @return 分页总数 
	 */
	public int getPageCountBySql(String sql, Serializable... values) {
		String getPageCountSql = "select count(*) from ( " + sql + " )";
		int count = 0 ;
		JSONArray resultJsonArray = this.getResultJsonArray(getPageCountSql, values);
		JSONObject resultJsonObject = resultJsonArray.getJSONObject(0);
		//获取jsonobject中值集合的迭代器
		Iterator<?> iterator = resultJsonObject.values().iterator();
		if(iterator.hasNext()){
			//返回的类型为java.math.BigDecimal
			count = ((BigDecimal) iterator.next()).intValue();
		}
		return count;
	}

	/**
	 * 通过sql语句和对应？值
	 * @param sql sql语句
	 * @param values ？值
	 * @return JSONObject
	 * @
	 */
	public JSONObject getJSONObject(String sql, Serializable... values) {
		JSONArray resultJsonArray = this.getResultJsonArray(sql, values);
		int count = resultJsonArray.size();
		if (count > 1) {
			throw new RuntimeException("单据数据不唯一，请联系管理员检查");
		} else if (count == 0) {
			throw new RuntimeException("没有查询到需要的数据");
		}
		return resultJsonArray.getJSONObject(0);
	}

	public JSONObject getGridJsonObject(String sql, Serializable... values) {
		System.out.println(sql);
		JSONObject result = new JSONObject();
		JSONArray root = getResultJsonArray(sql, values);
		int totalProperty = getPageCountBySql(sql, values);
		result.put("totalProperty", totalProperty);
		result.put("root", root);
		return result;
	}

	public JSONObject getGridJsonObjectAndPage(String sql, int start, int limit, Serializable... values) {
		JSONObject result = new JSONObject();
		JSONArray root = getResultJsonArrayByPage(sql, start, limit, values);
		int totalProperty = getPageCountBySql(sql, values);
		result.put("totalProperty", totalProperty);
		result.put("root", root);
		return result;
	}
	public List<String> getTablesName(String schema) {
		if (null == schema || "".equals(schema)){
			schema = "AHKYYY";
		}
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = this.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			//获取表信息的集合，有5列，第3列为表名
			rs = metaData.getTables(null, schema, null, null);
			List<String> tablesName = new ArrayList<String>();
			while (rs.next()) {
				tablesName.add(rs.getString(3));
			}
			return tablesName;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("getTablesName:"+e.getMessage(),e);
		} finally {
			this.close(rs, null, connection);
		}

	}

	public boolean createPocedure(String sql) {
		PreparedStatement ps = null;
		Connection connection = null;
		try {
			connection = this.getConnection();
			ps = connection.prepareStatement(sql);
			boolean isCreated = ps.execute();
			return isCreated;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("createpPocedure:"+e.getMessage(),e);
		} finally {
			this.close(null, ps ,connection);
		}

	}


	/**
	 * 暂时不用
	 * 
	 * @param start
	 * @param limit
	 * @param sql
	 * @return @
	 
	@Deprecated
	public JSONObject findbyPage1(int start, int limit, String sql) {
		try {
			String procedure = "{call PAGE_(?,?,?,?,?)}";
			CallableStatement call = this.getConnection().prepareCall(procedure);
			call.setString(1, sql);
			call.setInt(2, start);
			call.setInt(3, limit);
			call.registerOutParameter(4, Types.long);
			call.registerOutParameter(5, OracleTypes.CURSOR);
			call.execute();
			JSONObject result = new JSONObject();
			int totalProperty = call.getInt(4);
			ResultSet rs = (ResultSet) call.getObject(5);
			rs已在assembleJsonArraybyResultSet(rs)中关闭
			JSONArray root = this.assembleJsonArraybyResultSet(rs);
			result.put("totalProperty", totalProperty);
			result.put("root", root);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("findbyPage1:"+e.getMessage(),e);
		}

	}
*/
	
	/**
	 * 通过序列名获取下一个序列号
	 * 
	 * @param seqName
	 * @return 下一个序列号 
	 */
	public long getSeqNextValBySeqName(String seqName) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = this.getConnection();
			statement = connection.createStatement();
			String sql = "select " + seqName + ".nextval from dual";
			System.out.println("sqfjei"+sql);
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			int seqNextVal = resultSet.getInt(1);
			return seqNextVal;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取下一个序列号出错:"+e.getMessage(),e);
		} finally {
			this.close(resultSet, statement ,connection);
		}

	}
	//释放数据库和JDBC资源
	public void close(ResultSet rs, Statement statement,Connection con){
		try {
			if(rs != null){
				rs.close();
			}
			if(statement != null){
				statement.close();
			}
			//连接池的close()方法把连接返回到连接池而不是真正地关闭它
			if(con != null){
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("释放资源出错："+e.getMessage(),e);
		}
	}

	public long saveAndGetId(Serializable value) {
		HashMap<String, Object> map = getSqlBySerializableObj(value);
		String sql = (String) map.get("sqlStr");
		List<String> methodNames = (List<String>) map.get("methodNames");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null; 
		long autoIncKeyFromFunc = -1; 
		System.out.println("success====dffffdff====++++====dfddfdffd=========================<<<<<<<<");
		try {
			connection = this.getConnection();
			statement =  (PreparedStatement) connection.prepareStatement(sql);    

			for(int i=0; i<methodNames.size();i++){
				 Method method = value.getClass().getMethod(methodNames.get(i));
				 //得到他的返回类型    
	                Class cla = method.getReturnType();    

	                //根据返回类型来设置插入数据库中的每个属性值。    
	                if(cla.getName().equals("java.lang.String")) {    
	                    String returnValue = (String)method.invoke(value);    
	                    statement.setString(i+1, returnValue);    
	                }    
	                else if(cla.getName().equals("long")) {    
	                    long returnValue = (Long) method.invoke(value);    
	                    statement.setLong(i+1, returnValue);  
	                }else if(cla.getName().equals("java.util.Date")){
	                	Date time = (Date) method.invoke(value);
	                	statement.setDate(i+1,time);
	                }                       
			}
			statement.executeUpdate();
			rs = statement.executeQuery("SELECT LAST_INSERT_ID()");
			if(rs.next()){
				autoIncKeyFromFunc = rs.getInt(1);
			}else{
				throw new RuntimeException("autoIncKeyFromFunc failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取下一个序列号出错:"+e.getMessage(),e);
		} finally {
			this.close(rs, statement ,connection);
		}
		return autoIncKeyFromFunc;
	}

	private HashMap<String, Object> getSqlBySerializableObj(Serializable value) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String resultSql;
		StringBuffer sql = new StringBuffer("insert into ");
		List<String> columnNames = new ArrayList<String>();
		Method[] methods = value.getClass().getDeclaredMethods();
		List<String> selectedMehodNames = new ArrayList<String>();
		List<Object> columnVals = new ArrayList<Object>();
		sql.append(value.getClass().getSimpleName()+"(");
		for(Method method : methods){
			String methodName = method.getName();
			if(methodName.contains("get")){
				Annotation[] annotations = method.getAnnotations();
				if(annotations.length == 1){
					String annName = annotations[0].toString();
					System.out.println("-------------<<<" + annName);
					String[] containColums = annName.split(",");
					for(String containColum : containColums){
						if(containColum.contains("name=")){
							String temp = containColum.substring(6,containColum.length());
							columnNames.add(temp);
							selectedMehodNames.add(methodName);
						}
					}
				}
			}
		}
		System.out.println("++++++++=====>>>>>"+columnNames.get(0));
		for(String columnName : columnNames){
			sql.append(columnName).append(",");
		}
		resultSql = sql.substring(0, sql.length()-1) + ") values(";
		StringBuffer containVals = new StringBuffer(resultSql); 
		/*for(Object obj : columnVals){
			containVals.append(obj).append(",");
		}*/
		for(String columName : columnNames){
			containVals.append("?").append(",");
		}
		String resultSqlReal = containVals.substring(0, containVals.length() - 1);
		resultSqlReal += ")";
		map.put("sqlStr", resultSqlReal);
		map.put("methodNames", selectedMehodNames);
		return map;
	}
}
