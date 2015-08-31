package com.science.serviceManagerImpl;


import com.science.domain.Bookinfo;
import com.science.serviceManager.BookinfoManager;
import com.science.dao.BookinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class BookinfoManagerImpl extends BaseManagerImpl<Bookinfo> implements BookinfoManager {

	private BookinfoDao bookinfoDao;

	@Autowired
	public  void setBookinfoDao(BookinfoDao bookinfoDao){
		this.bookinfoDao=bookinfoDao;
		super.baseDao = bookinfoDao;
		this.bookinfoDao=bookinfoDao;


	}
	public  void addBookinfo(Bookinfo bookinfo){
		save(bookinfo);
	}
	public  void addBookinfos(List<Bookinfo> bookinfos){
		save(bookinfos);
	}
	public  Bookinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Bookinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Bookinfo> queryBookOrderByTime() {
		List<Bookinfo> bookinfos = findbyHql("from Bookinfo order by time Desc");
		return bookinfos;
	}
}
