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
	public List<Memberinfo> queryMemInfosByChengHao(String perPlain) {
		List<Memberinfo> memberinfos = findbyHql("from Memberinfo where perPlain like ?","%"+perPlain+"%");
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByForeignType(long foreignType) {
		List<Memberinfo> memberinfos = findByProperty("foreignType", foreignType);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByMemysType(long yuanshiType) {
		List<Memberinfo> memberinfos = findByProperty("yuanshiType", yuanshiType);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByTeacherType(String teacherType) {
		List<Memberinfo> memberinfos = findByProperty("teacherType", teacherType);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByMemJobTitle(String memJobTitle,String teacherType) {
		List<Memberinfo> memberinfos = memberinfoDao.findByHql("from Memberinfo where memJobTitle=? and teacherType<>?", memJobTitle,teacherType);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByMemJobTitle(String memJobTitle) {
		List<Memberinfo> memberinfos = findByProperty("memJobTitle", memJobTitle);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByMemTypeOfBoDao(String memType,
			String teacherType) {
		List<Memberinfo> memberinfos = memberinfoDao.findByHql("from Memberinfo where memType=? and teacherType=?", memType,teacherType);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByMemTypeProfess(String memType,
			String memJobTitle, String teacherType) {
		List<Memberinfo> memberinfos = memberinfoDao.findByHql("from Memberinfo where memType=? and memJobTitle=? and teacherType<>?", memType,memJobTitle,teacherType);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemInfosByMemTypeJobTitle(String memType,
			String memJobTitle) {
		List<Memberinfo> memberinfos = memberinfoDao.findByHql("from Memberinfo where memType=? and memJobTitle=?", memType,memJobTitle);
		return memberinfos;
	}
	@Override
	public List<Memberinfo> queryMemByMemTypeNotIn(String memType,
			String profess, String fuProfess, String jiangshi) {
		List<Memberinfo> memberinfos = memberinfoDao.findByHql("from Memberinfo where memType=? and memJobTitle not in (?,?,?)", memType,profess,fuProfess,jiangshi);
		return memberinfos;
	}
}
