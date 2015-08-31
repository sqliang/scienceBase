package com.science.serviceManager;


import com.science.domain.Paptentinfo;
import java.util.List;

public interface PaptentinfoManager extends BaseManager<Paptentinfo> {


	public void addPaptentinfo(Paptentinfo paptentinfo);

	public void addPaptentinfos(List<Paptentinfo> paptentinfos);

	public Paptentinfo load(String sqlkey);

	public List<Paptentinfo> find(String sqlkey);
	
	public List<Paptentinfo> queryPaptentOrderByTime();
}
