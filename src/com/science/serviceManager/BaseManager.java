package com.science.serviceManager;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.science.result.Dtype;
import com.science.result.ResultMode;

/**
 * 公共的服务接口
 * 
 * @author linpeng123l
 * 
 * @param <T>
 */
public interface BaseManager<T> {
	public void save(T t);

	public void save(List<T> t);

	public void update(T t);

	public void update(List<T> ts);

	public void delete(T t);

	public void delete(List<T> t);

	public T get(Serializable id);


	public List<T> findAll();

	public List<T> findAll(int start, int limit);

	

	public List<T> findbyHql(String hql, final Object... objects);

	

	public T findbyHqlUnique(String hql, Object... objects);

	public List<T> findByProperty(String name, Serializable value);
	public List<T> findByHqlNewSession(String hql,Object... objects);

	public T findByPropertyUnique(String name, Serializable value);

	public int countTotal();

	public int countTotalbyProperty(String name, Serializable value);

	public int countTotalbyPropertyL(String name, Serializable value);

	public int countTotalbyHql(String hql, Serializable... value);

	public List<T> findByPropertyL(String name, Serializable value, int start,
			int limit);

	public List<T> findByProperty(String name, Serializable value,
			long start, long limit);

	public ResultMode<T> findByProperty(Map<String, String> map, int start,
			int limit, Dtype type);

	public int deletebyProperty(String name, Serializable value);

	public int deletebyPropertys(String name, List<Long> values);

	boolean existReport(String djname, String fanganid) throws Exception;

	public void executeUpdate(String hql, Serializable... parameters);


}