package com.science.serviceManager;


import com.science.domain.Resourceinfo;
import java.util.List;

public interface ResourceinfoManager extends BaseManager<Resourceinfo> {


	public void addResourceinfo(Resourceinfo resourceinfo);

	public void addResourceinfos(List<Resourceinfo> resourceinfos);

	public Resourceinfo load(String sqlkey);

	public List<Resourceinfo> find(String sqlkey);
	
	public List<Resourceinfo> queryResourceByType(long resourceType);
	
	public List<Resourceinfo> queryResourceByTime();

}
