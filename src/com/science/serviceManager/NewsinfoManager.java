package com.science.serviceManager;


import com.science.domain.Newsinfo;
import java.util.List;

public interface NewsinfoManager extends BaseManager<Newsinfo> {


	public void addNewsinfo(Newsinfo newsinfo);

	public void addNewsinfos(List<Newsinfo> newsinfos);

	public Newsinfo load(String sqlkey);

	public List<Newsinfo> find(String sqlkey);

	public List<Newsinfo> queryNewsinfoByType(long newsType);
}
