package com.science.serviceManagerImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.science.dao.BaseDao;
import com.science.result.Dtype;
import com.science.result.ResultMode;
import com.science.serviceManager.BaseManager;

/**
 * 
 * @author kevin
 *
 * @param <T>
 */
@Component
public class BaseManagerImpl<T extends Serializable> implements BaseManager<T> {
	
	protected BaseDao<T> baseDao;
	/*
	public void save(T t) ;
	public void update(T t) ;
	public void delete(T t) ;
	public T get(Serializable id) ;
	public List<T> findAll() ;
	public List<T> findByExample(T t) ;
	public List<T> findbyHQLsingleTable(String hql,final Object...objects) ;
	public List<T> findByProperty(Serializable value,String name) ;
	public PageInfo<T> findPageInfo(int page) ;
	public PageInfo<T> findPageInfo(PageInfo<T> pageInfo) ;
	public PageInfo<T> findPageInfo(int page,int pagesize,String orderBy,String order) ;*/

	@Override
	public void save(T t)  {
		// TODO Auto-generated method stub
		baseDao.save(t);
		
	}

	@Override
	public void save(List<T> ts)  {
		// TODO Auto-generated method stub
		if(ts!=null){
			for(int i = 0; i < ts.size(); i++){
				baseDao.save(ts.get(i));
			}
		}
		
	}


	@Override
	public void executeUpdate(String hql,Serializable... parameters){
		baseDao.executeUpdate(hql, parameters);
	}
	@Override
	public void update(T t)  {
		// TODO Auto-generated method stub
		baseDao.update(t);
		System.out.println("=====");
	}
	@Override
	public void update(List<T> ts)  {
		// TODO Auto-generated method stub
		if(ts!=null){
			for(int i = 0; i < ts.size(); i++){
				baseDao.update(ts.get(i));
			}
		}
	}

	@Override
	public void delete(T t)  {
		// TODO Auto-generated method stub
		baseDao.delete(t);
	}

	@Override
	public void delete(List<T> ts)  {
		baseDao.delete(ts);
	}
	@Override
	public T get(Serializable id)  {
		return baseDao.get(id);
	}


	@Override
	public List<T> findAll()  {
		return baseDao.findAll();
	}

	

	@Override
	public List<T> findbyHql(String hql, Object... objects)
			 {
		// TODO Auto-generated method stub
		return baseDao.findByHql(hql, objects);
	}
	public List<T> findbyHqlP(String hql,int start,int limit,final Object... objects)
			{
		return baseDao.findByHql(hql,start,limit, objects);
	}
	public T findbyHqlUnique(String hql,Object... objects){
		return baseDao.findbyHqlUnique(hql, objects);
	}
	@Override
	public List<T> findByProperty(String name, Serializable value)
			 {
		// TODO Auto-generated method stub
		return baseDao.findByProperty(name, value);
	}
	@Override
	public List<T> findByHqlNewSession(String hql,Object... objects){
		return baseDao.findByHqlNewSession(hql, objects);
	}

	@Override
	public List<T> findByPropertyL(String name, Serializable value, int start,
			int limit)  {
		// TODO Auto-generated method stub
		return baseDao.findByPropertyL(name, value, start, limit);
	}

	public List<T> findByProperty(String name,Serializable value,long start,long limit) {
		return baseDao.findByProperty(name, value, start, limit);
	}
	@Override
	public List<T> findAll(int start, int limit)  {
		// TODO Auto-generated method stub
		return baseDao.findAll(start, limit);
	}

	@Override
	public int countTotal()  {
		return baseDao.findAllCount(null);
	}

	@Override
	public int countTotalbyProperty(String name,Serializable value)  {
		// TODO Auto-generated method stub
		String hql = "select count(*) from "+ baseDao.getEntityClass().getSimpleName()+" where "+name+ " = ?";
		return baseDao.countByHql(hql, value);
	}

	@Override
	public int countTotalbyPropertyL(String name,Serializable value)  {
		// TODO Auto-generated method stub
		String hql = "select count(*) from "+ baseDao.getEntityClass().getSimpleName()+" where "+name+ " like '%"+value+"%'";
		return baseDao.findAllCount(hql);
	}

	@Override
	public int countTotalbyHql(String hql, Serializable... value)
			 {
		
		return 0;
	}

	@Override
	public int deletebyProperty(String name,Serializable value)  {
		return baseDao.deletebyProperty(name, value);
	}

	@Override
	public ResultMode<T> findByProperty(Map<String, String> map, int start,
			int limit, Dtype type)  {
		return baseDao.findByProperty(map, start, limit, type);
	}

	@Override
	public T findByPropertyUnique(String name, Serializable value)
			 {
		return baseDao.findByPropertyUnique(name, value);
	}

	@Override
	public int deletebyPropertys(String name, List<Long> values)  {
		return baseDao.deletebyPropertys(name, values);
	}

	@Override
	public boolean existReport(String djname, String fanganid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}