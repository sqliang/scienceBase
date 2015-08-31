package com.science.serviceManager;


import com.science.domain.Projectinfo;
import java.util.List;

public interface ProjectinfoManager extends BaseManager<Projectinfo> {


	public void addProjectinfo(Projectinfo projectinfo);

	public void addProjectinfos(List<Projectinfo> projectinfos);

	public Projectinfo load(String sqlkey);

	public List<Projectinfo> find(String sqlkey);
	
	public List<Projectinfo> queryProjectOrderBytime();

}
