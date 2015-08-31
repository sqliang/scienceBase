package com.science.serviceManagerImpl;


import com.science.domain.Classinfo;
import com.science.serviceManager.ClassinfoManager;
import com.science.dao.ClassinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class ClassinfoManagerImpl extends BaseManagerImpl<Classinfo> implements ClassinfoManager {

	private ClassinfoDao classinfoDao;

	@Autowired
	public  void setClassinfoDao(ClassinfoDao classinfoDao){
		this.classinfoDao=classinfoDao;
		super.baseDao = classinfoDao;
		this.classinfoDao=classinfoDao;


	}
	public  void addClassinfo(Classinfo classinfo){
		save(classinfo);
	}
	public  void addClassinfos(List<Classinfo> classinfos){
		save(classinfos);
	}
	public  Classinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Classinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Classinfo> queryClassinfoByTime() {
		List<Classinfo> classinfos = findbyHql("from Classinfo order by time Desc");
		return classinfos;
	}
}
