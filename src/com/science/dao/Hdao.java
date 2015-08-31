package com.science.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Hdao {
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	private Session session;

	public Session getSession(){		
		session = sessionFactory.getCurrentSession();		
		return session;
	}

	public void save(List<?> list){
		session = this.getSession();
		for(Object object : list){
			session.save(object);
		}
	}

	public void save(Object object){
		this.getSession().save(object);
	}
	/**
	 * 更新一个对象
	 * @param object 需要更新的对象
	 * @ 需要抛出的异常
	 */
	public void update(Object object) {
		this.getSession().update(object);
	}

	/**
	 * 更新对象集合
	 * @param ts 需要更新的对象集合
	 * @ 需要抛出的异常
	 */
	public void update(List<Object> ts) {
		if(ts!=null){
			for(Object object : ts){
				this.getSession().update(object);
			}
		}
	}

	/**
	 * 此处根据传入对象的主键删除数据库中对应的数据
	 * @param object 需要删除的数据（包含主键，即id）
	 * @ 抛出异常
	 */
	public void delete(Object object) {
		this.getSession().delete(object);
	}
	/**
	 * 此处根据传入对象的主键删除数据库中对应的数据
	 * @param ts 需要删除的数据集合（包含主键，即id）
	 * @ 抛出异常
	 */
	public void delete(List<Object> ts) {
		if(ts!=null){
			for(Object object : ts){
				this.getSession().delete(object);
			}
		}
	}
	/**
	 * 查询对应表所有数据的总数
	 * @return int 表中记录总数
	 * @ 抛出异常，方便spring处理
	 */
	public int countByHql(String hql,Serializable... values)  {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		int count = ((Long)query.uniqueResult()).intValue();
		return count;
	}
	/**
	 * 通过编写hql查询
	 * @param hql 编写的hql
	 * @param objects hql中需要注入的参数
	 * @ 抛出异常，方便spring处理
	 */
	@SuppressWarnings("unchecked")
	public List<Object> findByHql(String hql,Object... objects) {
		List<Object> list=null;
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		list = query.list();
		return list;
	}
	/**
	 * 通过编写hql查询
	 * @param hql 编写的hql
	 * @param objects hql中需要注入的参数
	 * @ 抛出异常，方便spring处理
	 */
	@SuppressWarnings("unchecked")
	public List<Object> findByHql(String hql,int start,int limit,final Object... objects) {
		List<Object> list=null;
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		query.setFirstResult(start);
		query.setMaxResults(limit);

		list = query.list();
		return list;
	}
	public Object findbyHqlUnique(String hql, Object... objects) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		Object object = (Object) query.uniqueResult();
		return object;
	}

	/**
	 * 通过编写hql更新数据
	 * @param hql 编写的hql
	 * @param parameters hql中需要注入的参数
	 * @ 抛出异常，方便spring处理
	 */
	public void executeUpdate(String hql,String parameters[]) {
		Session session=this.getSession();
		Query query=session.createQuery(hql);
		if(parameters!=null&&parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setString(i, parameters[i]);
			}
		}
		query.executeUpdate();
	}
	/**
	 * 自定义sql查询
	 * @param sql 编写的sql语句
	 * @param objects hql中需要注入的参数
	 * @ 抛出异常，方便spring处理
	 */
	@SuppressWarnings("unchecked")
	public List<Object> findBySql(String sql,final Object...objects){
		List<Object> list=null;
		Query query = this.getSession().createSQLQuery(sql);
		for (int i = 0; objects!=null&&i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		list = query.list();
		return list;
	}
	/**
	 * 通过属性值删除数据
	 * @param value 属性值
	 * @param name 属性名 
	 * @return 删除数据条数
	 * @ 抛出异常，方便spring处理
	 */
	public int deletebyHql(String hql,Serializable... values) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; values!=null&&i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query.executeUpdate();
	}
}
