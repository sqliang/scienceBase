package com.science.serviceManagerImpl;


import com.science.domain.Studentinfo;
import com.science.serviceManager.StudentinfoManager;
import com.science.dao.StudentinfoDao;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class StudentinfoManagerImpl extends BaseManagerImpl<Studentinfo> implements StudentinfoManager {

	private StudentinfoDao studentinfoDao;

	@Autowired
	public  void setStudentinfoDao(StudentinfoDao studentinfoDao){
		this.studentinfoDao=studentinfoDao;
		super.baseDao = studentinfoDao;
		this.studentinfoDao=studentinfoDao;


	}
	public  void addStudentinfo(Studentinfo studentinfo){
		save(studentinfo);
	}
	public  void addStudentinfos(List<Studentinfo> studentinfos){
		save(studentinfos);
	}
	public  Studentinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Studentinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	
	@Override
	public List<Studentinfo> queryStudentsByDegree(String stuDegree) {
		List<Studentinfo> studentinfos = findbyHql("from Studentinfo where studegree=?", stuDegree);
		return studentinfos;
	}
	@Override
	public List<Studentinfo> queryStudentByFenye(String stuDegree,long start, long limit) {
		List<Studentinfo> studentinfos = studentinfoDao.findByHqlP("from Studentinfo where stuDegree=? order by stuId Desc",(int)start, (int)limit,stuDegree);
		return studentinfos;
	}
	@Override
	public List<Studentinfo> adminQueryStudent(long start, long limit) {
		List<Studentinfo> studentinfos = studentinfoDao.findByHqlP("from Studentinfo order by stuId Desc",(int)start, (int)limit);
		return studentinfos;
	}	
}
