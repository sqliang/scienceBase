package com.science.serviceManager;


import com.science.domain.Classgradeinfo;
import java.util.List;

public interface ClassgradeinfoManager extends BaseManager<Classgradeinfo> {


	public void addClassgradeinfo(Classgradeinfo classgradeinfo);

	public void addClassgradeinfos(List<Classgradeinfo> classgradeinfos);

	public Classgradeinfo load(String sqlkey);

	public List<Classgradeinfo> find(String sqlkey);
	
	public List<Classgradeinfo> queryClassGradeinfoByTime();

}
