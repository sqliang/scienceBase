package com.science.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.science.util.bean.BeanUtil;

public class JdaoUtil {
	private static Jdao jdao;
    static {
		jdao = (Jdao) BeanUtil.load("jdao");
	}

	public static JSONArray getResultJsonArray(String sql, Serializable... values) {
		return jdao.getResultJsonArray(sql, values);
	}

	/**
	 * add by wdl 实现对表的操作，如：增删改，只有一条操作语句，不需考虑事务
	 * @param sql
	 * @param values
	 */
	public static void operateTable(String sql, Serializable... values) {
		jdao.operateTable(sql, values);
	}

	//oracle关键字ROWNUM显示行号，只有使用别名的时候才能使用大于号
	public static JSONArray getResultJsonArrayByPage(String sql, int start, int limit,Serializable... values) {
		return jdao.getResultJsonArrayByPage(sql, start, limit, values);
	}

	/**
	 * 
	 * @param sql
	 * @return 以字符串形式返回第一行第一列的值
	 */
	public static String simpleSQL(String sql,Serializable... values) {
		return jdao.simpleSQL(sql, values);
	}

	/**
	 * 
	 * @param sql
	 * @return 以字符串集合形式返回第一列的值
	 */
	public static List<String> simpleSQLAsList(String sql,Serializable... values) {
		return jdao.simpleSQLAsList(sql, values);
	}

	/**
	 * 通过sql语句和对应？值
	 * @param sql sql语句
	 * @param values ？值
	 * @return JSONObject
	 * @
	 */
	public static JSONObject getJSONObject(String sql, Serializable... values) {
		return jdao.getJSONObject(sql, values);
	}


	public static List<String> getTablesName(String schema) {
		return jdao.getTablesName(schema);
	}

	public static boolean createPocedure(String sql) {
		return jdao.createPocedure(sql);
	}

	/**
	 * 通过序列名获取下一个序列号
	 * 
	 * @param seqName
	 * @return 下一个序列号 
	 */
	public static long getSeqNextValBySeqName(String seqName) {
		return jdao.getSeqNextValBySeqName(seqName);
	}
	//释放数据库和JDBC资源
	public static void close(ResultSet rs, Statement statement,Connection con){
		jdao.close(rs, statement, con);
	}
}
