package com.science.serviceManagerImpl;


import com.science.domain.Memberinfo;
import com.science.serviceManager.MemberinfoManager;
import com.science.dao.MemberinfoDao;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class MemberinfoManagerImpl extends BaseManagerImpl<Memberinfo> implements MemberinfoManager {

	private MemberinfoDao memberinfoDao;

	@Autowired
	public  void setMemberinfoDao(MemberinfoDao memberinfoDao){
		this.memberinfoDao=memberinfoDao;
		super.baseDao = memberinfoDao;
		this.memberinfoDao=memberinfoDao;


	}
	public  void addMemberinfo(Memberinfo memberinfo){
		save(memberinfo);
	}
	public  void addMemberinfos(List<Memberinfo> memberinfos){
		save(memberinfos);
	}
	public  Memberinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Memberinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Memberinfo> queryMemInfosByChengHao(String memChengHao) {
		System.out.println(memChengHao);
		List<Memberinfo> memberinfos = findbyHql("from Memberinfo where memchenghao like ?","%"+memChengHao+"%");
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByMemType(String memType) {
		List<Memberinfo> memberinfos = findByProperty("memType", memType);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByForeignType(long foreignType) {
		List<Memberinfo> memberinfos = findByProperty("foreignType", foreignType);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByMemDegree(String memDegree) {
		List<Memberinfo> memberinfos = findByProperty("memDegree", memDegree);
		return memberinfos;
	}
}
