package com.science.serviceManager;


import com.science.domain.Classinfo;
import java.util.List;

public interface ClassinfoManager extends BaseManager<Classinfo> {


	public void addClassinfo(Classinfo classinfo);

	public void addClassinfos(List<Classinfo> classinfos);

	public Classinfo load(String sqlkey);

	public List<Classinfo> find(String sqlkey);
	
	public List<Classinfo> queryClassinfoByTime();

}
