package com.science.serviceManager;


import com.science.domain.Memberinfo;

import java.util.List;

public interface MemberinfoManager extends BaseManager<Memberinfo> {


	public void addMemberinfo(Memberinfo memberinfo);

	public void addMemberinfos(List<Memberinfo> memberinfos);

	public Memberinfo load(String sqlkey);

	public List<Memberinfo> find(String sqlkey);
	
	public List<Memberinfo> queryMemInfosByChengHao(String perPlain);
	
	public List<Memberinfo> queryMemInfosByMemTypeOfBoDao(String memType,String teacherType);//博导，
	
	public List<Memberinfo> queryMemInfosByMemTypeProfess(String memType,String memJobTitle,String teacherType);//除博导外的教授
	
	public List<Memberinfo> queryMemInfosByMemTypeJobTitle(String memType,String memJobTitle);//副教授，讲师，其他	
	
	public List<Memberinfo> queryMemByMemTypeNotIn(String memType,String profess,String fuProfess,String jiangshi);
	
	public List<Memberinfo> queryMemInfosByForeignType(long foreignType);
	
	public List<Memberinfo> queryMemInfosByMemysType(long yuanshiType);
	
	public List<Memberinfo> queryMemInfosByTeacherType(String teacherType);
	
	public List<Memberinfo> queryMemInfosByMemJobTitle(String memJobTitle);
	
	public List<Memberinfo> queryMemInfosByMemJobTitle(String memJobTitle,String teacherType);
}
