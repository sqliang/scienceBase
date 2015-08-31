package com.science.serviceManager;


import com.science.domain.Memberinfo;

import java.util.List;

public interface MemberinfoManager extends BaseManager<Memberinfo> {


	public void addMemberinfo(Memberinfo memberinfo);

	public void addMemberinfos(List<Memberinfo> memberinfos);

	public Memberinfo load(String sqlkey);

	public List<Memberinfo> find(String sqlkey);
	
	public List<Memberinfo> queryMemInfosByChengHao(String memChengHao);
	
	public List<Memberinfo> queryMemInfosByMemType(String memType);
	
	public List<Memberinfo> queryMemInfosByForeignType(long foreignType);
	
	public List<Memberinfo> queryMemInfosByMemDegree(String memDegree);
}
