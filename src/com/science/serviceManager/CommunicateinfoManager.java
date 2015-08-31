package com.science.serviceManager;

import java.util.List;

import com.science.domain.Communicateinfo;

public interface CommunicateinfoManager extends BaseManager<Communicateinfo> {
	
	public void addCommunicateinfo(Communicateinfo communicateinfo);
	
	public void addCommunicateinfos(List<Communicateinfo> communicateinfos);
	
	public Communicateinfo load(String sqlkey);

	public List<Communicateinfo> find(String sqlkey);
	
	public List<Communicateinfo> queryCommuicateByType(long communicateType);
	
	public List<Communicateinfo> queryCommuicateByTime();
}
