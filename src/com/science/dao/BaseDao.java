package com.science.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.Id;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.science.result.Dtype;
import com.science.result.ResultMode;
import com.science.util.StringUtil;

@Component
public class BaseDao<T extends Serializable> {
	@Autowired(required = true)
	private SessionFactory sessionFactory;
	private Session session;
	@SuppressWarnings("rawtypes")
	private Class entityClass;
	private String pkname = "id";
	private final String HQL_LIST_ALL;
	private final String HQL_COUNT_ALL;

	@SuppressWarnings("rawtypes")
	public Class getEntityClass() {
		return entityClass;
	}

	@SuppressWarnings("rawtypes")
	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}

	public Session getSession() {
		session = sessionFactory.getCurrentSession();
		return session;
	}

	private Session openSession() {
		return this.sessionFactory.openSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("rawtypes")
	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		if(!this.getClass().getSimpleName().equals("BaseDao")&&!(type instanceof Class)){
			if (type.toString().indexOf("BaseDao") != -1) {
				ParameterizedType type1 = (ParameterizedType) type;
				Type[] types = type1.getActualTypeArguments();
				setEntityClass((Class) types[0]);
			}else{
				type = ((Class)type).getGenericSuperclass();
				ParameterizedType type1 = (ParameterizedType) type;
				Type[] types = type1.getActualTypeArguments();
				setEntityClass((Class) types[0]);
			}
			getPkname();
			HQL_LIST_ALL= "from "+this.entityClass.getSimpleName()+" order by "+pkname+" desc";
			HQL_COUNT_ALL="select count(*) from "+this.entityClass.getSimpleName();
		}else{
			HQL_LIST_ALL = "";
			HQL_COUNT_ALL="";
		}
	}
	/**
	 * 返回模型类所属包名
	 * 
	 * @return 包名
	 */
	public String getPkname() {
		Field[] fields = this.entityClass.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class)) {
				this.pkname = field.getName();
				break;
			}
		}
		return pkname;
	}

	/**
	 * 保存一个对象T
	 * 
	 * @param t
	 *            需要保存的对象 @ 保存错误抛出的异常
	 */
	public void save(T t) {
		this.getSession().save(t);
	}

	/**
	 * 保存对象集合
	 * 
	 * @param ts
	 *            对象集合 @
	 */
	public void save(List<T> ts) {
		if (ts != null) {
			for (int i = 0; i < ts.size(); i++) {
				this.save(ts.get(i));
			}
		}
	}

	/**
	 * 更新一个对象
	 * 
	 * @param t
	 *            需要更新的对象 @ 需要抛出的异常
	 */
	public void update(T t) {
		this.getSession().update(t);
	}

	/**
	 * 更新对象集合
	 * 
	 * @param ts
	 *            需要更新的对象集合 @ 需要抛出的异常
	 */
	public void update(List<T> ts) {
		if (ts != null) {
			for (T t : ts) {
				this.update(t);
			}
		}
	}

	/**
	 * 此处根据传入对象的主键删除数据库中对应的数据
	 * 
	 * @param t
	 *            需要删除的数据（包含主键，即id） @ 抛出异常
	 */
	public void delete(T t) {
		this.getSession().delete(t);
	}

	/**
	 * 此处根据传入对象的主键删除数据库中对应的数据
	 * 
	 * @param ts
	 *            需要删除的数据集合（包含主键，即id） @ 抛出异常
	 */
	public void delete(List<T> ts) {
		if (ts != null) {
			for (T t : ts) {
				this.getSession().delete(t);
			}
		}
	}

	/**
	 * 此处根据传入的主键得到一个数据库中对应的数据
	 * 
	 * @param id
	 *            对应表数据的主键 @ 抛出异常，方便spring处理
	 */
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		T t = null;
		t = (T) this.getSession().get(this.getEntityClass(), id);
		return t;
	}

	/**
	 * 查询T表中所有的数据 @ 抛出异常，方便spring处理
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> list = null;
		Query query = this.getSession().createQuery(HQL_LIST_ALL);
		list = query.list();
		return list;
	}

	/**
	 * 查询对应表所有数据的总数
	 * 
	 * @return int 表中记录总数 @ 抛出异常，方便spring处理
	 */
	public int findAllCount(String hql, Serializable... values) {
		String counthql = StringUtil.isEmpty(hql) ? HQL_COUNT_ALL : hql;
		Query query = this.getSession().createQuery(counthql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		int count = ((Long) query.uniqueResult()).intValue();
		return count;
	}

	/**
	 * 查询对应表所有数据的总数
	 * 
	 * @return int 表中记录总数 @ 抛出异常，方便spring处理
	 */
	public int findAllCount1(String hql, Serializable... values) {
		String counthql = StringUtil.isEmpty(hql) ? HQL_COUNT_ALL : hql;
		Query query = sessionFactory.openSession().createQuery(counthql);
		sessionFactory.openSession().close();
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		int count = ((Long) query.uniqueResult()).intValue();
		return count;
	}

	/**
	 * 查询对应表所有数据的总数
	 * 
	 * @return int 表中记录总数 @ 抛出异常，方便spring处理
	 */
	public int countByHql(String hql, Serializable... values) {
		if (hql.trim().startsWith("and")) {
			hql = "from " + entityClass.getSimpleName() + " where 1 = 1 " + hql;
		}
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		int count = ((Long) query.uniqueResult()).intValue();
		return count;
	}

	/**
	 * 通过编写hql查询,此处hql并不是完整意义上的sql，指直接拼接到from之后的条件
	 * 
	 * @param hql
	 *            编写的hql
	 * @param objects
	 *            hql中需要注入的参数 @ 抛出异常，方便spring处理
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByHql(String hql, Object... objects) {
		if (hql.trim().startsWith("and")) {
			hql = "from " + entityClass.getSimpleName() + " where 1 = 1 " + hql;
		}
		List<T> list = null;
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		list = query.list();
		return list;
	}

	/**
	 * 新开一个session，来实现查询物理数据，不受其他session干扰
	 * 
	 * @param hql
	 *            编写的hql
	 * @param objects
	 *            hql中需要注入的参数 @ 抛出异常，方便spring处理
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByHqlNewSession(String hql, Object... objects) {
		if (hql.trim().startsWith("and")) {
			hql = "from " + entityClass.getSimpleName() + " where 1 = 1 " + hql;
		}
		List<T> list = null;
		Session session = this.openSession();
		Query query = session.createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		list = query.list();
		return list;
	}

	/**
	 * 通过编写hql查询,来进行分页
	 * 
	 * @param hql
	 *            编写的hql
	 * @param objects
	 *            hql中需要注入的参数 @ 抛出异常，方便spring处理
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByHqlP(String hql, int start, int limit,
			final Object... objects) {
		if (hql.trim().startsWith("and")) {
			hql = "from " + entityClass.getSimpleName() + " where 1 = 1 " + hql;
		}
		List<T> list = null;
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		query.setFirstResult(start);
		query.setMaxResults(limit);

		list = query.list();
		return list;
	}

	/**
	 * @note 如果and开头拼接
	 * @title findbyHqlUnique
	 * @description TODO
	 * @param hql
	 * @param objects
	 * @return T
	 * @user jonathan
	 * @throws
	 */
	public T findbyHqlUnique(String hql, Object... objects) {
		if (hql.trim().startsWith("and")) {
			hql = "from " + entityClass.getSimpleName() + " where 1 = 1 " + hql;
		}
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		@SuppressWarnings("unchecked")
		T t = (T) query.uniqueResult();
		return t;
	}

	/**
	 * 通过编写hql更新数据
	 * 
	 * @param hql
	 *            编写的hql
	 * @param parameters
	 *            hql中需要注入的参数 @ 抛出异常，方便spring处理
	 */
	public void executeUpdate(String hql, Serializable... parameters) {
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		query.executeUpdate();
	}

	/**
	 * 通过一个属性和对应值去相关表中查询数据
	 * 
	 * @param name
	 *            属性名
	 * @param value
	 *            对应属性值
	 * @return List<T> @ 抛出异常，方便spring处理
	 */
	public List<T> findByProperty(String name, Serializable value) {
		String hql = "from " + entityClass.getSimpleName() + " where " + name
				+ " = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, value);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}

	/**
	 * 通过一个属性和对应值去相关表中查询数据
	 * 
	 * @param name
	 *            属性名
	 * @param value
	 *            对应属性值
	 * @return List<T> @ 抛出异常，方便spring处理
	 */
	public List<T> findByProperty(String name, Serializable value, long start,
			long limit) {
		String hql = "from " + entityClass.getSimpleName() + " where " + name
				+ " = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, value);
		query.setFirstResult((int) start);
		query.setMaxResults((int) limit);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}

	/**
	 * 
	 * 通过一个属性和对应值去相关表中查询数据(分页)
	 * 
	 * @param name
	 *            属性名
	 * @param value
	 *            对应属性值
	 * @param start
	 *            起始位置
	 * @param limit
	 *            总数
	 * @return List<T> @ 抛出异常，方便spring处理
	 */
	public List<T> findByPropertyL(String name, Serializable value, int start,
			int limit) {
		String hql = "from " + entityClass.getSimpleName() + " where " + name
				+ " like ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, "%" + value + "%");
		query.setFirstResult(start);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}

	/**
	 * 
	 * 通过一个属性和对应值去相关表中查询数据(分页)
	 * 
	 * @param map
	 *            属性和值的集合
	 * @param start
	 *            起始位置
	 * @param limit
	 *            总数
	 * @param type
	 *            查询类型
	 * @return 记过 @ 抛出异常，方便spring处理
	 */
	public ResultMode<T> findByProperty(Map<String, String> map, int start,
			int limit, Dtype type) {
		ResultMode<T> resultMode = new ResultMode<T>();
		String hql = "from " + entityClass.getSimpleName() + " where 2 > 1 ";
		String dtype = " = ";
		if (type == Dtype.equal)
			dtype = " = ";
		if (type == Dtype.like)
			dtype = " like ";
		Set<Entry<String, String>> entryset = map.entrySet();
		Iterator<Entry<String, String>> it = entryset.iterator();
		String key = "";
		String value = "";
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			key = entry.getKey();
			value = entry.getValue();
			if (type == Dtype.like)
				value = "%" + value + "%";
			hql += " and " + key + dtype + "'" + value + "'";
		}
		int total = findAllCount("select count(*) " + hql);
		Query query = this.getSession().createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		resultMode.setTotalProperty(total);
		resultMode.setRoot(list);
		return resultMode;
	}

	@SuppressWarnings("unchecked")
	public T findByPropertyUnique(String name, Serializable value) {
		String hql = "from " + entityClass.getSimpleName() + " where " + name
				+ " =? ";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, value);
		return (T) query.uniqueResult();
	}

	/**
	 * 查询所有数据（分页）
	 * 
	 * @param start
	 *            起始位置
	 * @param limit
	 *            总数
	 * @return List<T> @ 抛出异常，方便spring处理
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(int start, int limit) {
		String hql = "from " + entityClass.getSimpleName();
		Query query = this.getSession().createQuery(hql);
		query.setFirstResult(start);
		query.setMaxResults(limit);
		return query.list();
	}

	/**
	 * 通过属性值删除数据
	 * 
	 * @param value
	 *            属性值
	 * @param name
	 *            属性名
	 * @return 删除数据条数 @ 抛出异常，方便spring处理
	 */
	public int deletebyProperty(String name, Serializable value) {
		String hql = "delete " + entityClass.getSimpleName() + " where " + name
				+ " =  ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, value);
		return query.executeUpdate();
	}

	/**
	 * 通过属性值删除数据
	 * 
	 * @param value
	 *            属性值
	 * @param name
	 *            属性名
	 * @return 删除数据条数 @ 抛出异常，方便spring处理
	 */
	public void deletebyPropertys(String name, Serializable... values) {
		if (values == null) {
			return;
		}
		for (Serializable value : values) {
			deletebyProperty(name, value);
		}
	}

	/**
	 * 
	 * @param name
	 * @param values
	 * @return
	 */
	public int deletebyPropertys(String name, List<Long> values) {
		if (values == null) {
			return 0;
		}
		for (long value : values) {
			deletebyProperty(name, value);
		}
		return 0;
	}

	/**
	 * @note 新开session,提供查询数据库原始数据，不受别的session事物的干扰
	 */

}