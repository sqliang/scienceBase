package com.science.serviceManager;


import com.science.domain.Labgradeinfo;
import java.util.List;

public interface LabgradeinfoManager extends BaseManager<Labgradeinfo> {


	public void addLabgradeinfo(Labgradeinfo labgradeinfo);

	public void addLabgradeinfos(List<Labgradeinfo> labgradeinfos);

	public Labgradeinfo load(String sqlkey);

	public List<Labgradeinfo> find(String sqlkey);
	
	public List<Labgradeinfo> queryLabGradeOrderByTime();

}
