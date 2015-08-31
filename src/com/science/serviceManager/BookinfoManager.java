package com.science.serviceManager;


import com.science.domain.Bookinfo;
import java.util.List;

public interface BookinfoManager extends BaseManager<Bookinfo> {


	public void addBookinfo(Bookinfo bookinfo);

	public void addBookinfos(List<Bookinfo> bookinfos);

	public Bookinfo load(String sqlkey);

	public List<Bookinfo> find(String sqlkey);
	
	public List<Bookinfo> queryBookOrderByTime();

}
