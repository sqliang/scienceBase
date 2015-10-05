package com.science.serviceManagerImpl;


import com.science.domain.Newsinfo;
import com.science.serviceManager.NewsinfoManager;
import com.science.dao.NewsinfoDao;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.enterprise.inject.New;

@Component
public class NewsinfoManagerImpl extends BaseManagerImpl<Newsinfo> implements NewsinfoManager {

	private NewsinfoDao newsinfoDao;

	@Autowired
	public  void setNewsinfoDao(NewsinfoDao newsinfoDao){
		this.newsinfoDao=newsinfoDao;
		super.baseDao = newsinfoDao;
		this.newsinfoDao=newsinfoDao;


	}
	public  void addNewsinfo(Newsinfo newsinfo){
		save(newsinfo);
	}
	public  void addNewsinfos(List<Newsinfo> newsinfos){
		save(newsinfos);
	}
	public  Newsinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Newsinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	
	public List<Newsinfo> queryNewsinfoByType(long newsType){
		List<Newsinfo>  newsinfos = findbyHql("from Newsinfo where newsType=? order by time Desc", newsType);
		return newsinfos;
	}
	@Override
	public Newsinfo queryNewsinfoById(long newsId) {
		Newsinfo newsinfo = findbyHqlUnique("from Newsinfo where newsId=?", newsId);
		return newsinfo;
	}
	@Override
	public void delNewsById(long newsid) {
		newsinfoDao.deletebyPropertys("newsid", newsid);
	}
}
