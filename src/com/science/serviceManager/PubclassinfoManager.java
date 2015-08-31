package com.science.serviceManager;

import java.util.List;

import com.science.domain.Pubclassinfo;

public interface PubclassinfoManager extends BaseManager<Pubclassinfo> {
	
	public void addPubclassinfo(Pubclassinfo pubclassinfo);
	
	public void addPubclassinfos(List<Pubclassinfo> pubclassinfos);
	
	public Pubclassinfo load(String sqlkey);
	
	public List<Pubclassinfo> find(String sqlkey);
	
	public List<Pubclassinfo> queryPubclassBytime();
}
