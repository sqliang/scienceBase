package com.science.serviceManagerImpl;


import com.science.domain.Picnews;
import com.science.serviceManager.PicnewsManager;
import com.science.dao.PicnewsDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class PicnewsManagerImpl extends BaseManagerImpl<Picnews> implements PicnewsManager {

	private PicnewsDao picnewsDao;

	@Autowired
	public  void setPicnewsDao(PicnewsDao picnewsDao){
		this.picnewsDao=picnewsDao;
		super.baseDao = picnewsDao;
		this.picnewsDao=picnewsDao;


	}
	public  void addPicnews(Picnews picnews){
		save(picnews);
	}
	public  void addPicnewss(List<Picnews> picnewss){
		save(picnewss);
	}
	public  Picnews load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Picnews> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Picnews> queryPicNews() {
		List<Picnews> picnewss = findAll();
		for(Picnews picnews : picnewss){
			picnews.loadNewsinfonewsid();
		}
		return picnewss;
	}
	@Override
	public void delPicNewsByNewsId(long newsId) {
		picnewsDao.deletebyPropertys("newsid", newsId);
	}
	
}
