package com.science.serviceManagerImpl;


import com.science.domain.Classgradeinfo;
import com.science.serviceManager.ClassgradeinfoManager;
import com.science.dao.ClassgradeinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class ClassgradeinfoManagerImpl extends BaseManagerImpl<Classgradeinfo> implements ClassgradeinfoManager {

	private ClassgradeinfoDao classgradeinfoDao;

	@Autowired
	public  void setClassgradeinfoDao(ClassgradeinfoDao classgradeinfoDao){
		this.classgradeinfoDao=classgradeinfoDao;
		super.baseDao = classgradeinfoDao;
		this.classgradeinfoDao=classgradeinfoDao;


	}
	public  void addClassgradeinfo(Classgradeinfo classgradeinfo){
		save(classgradeinfo);
	}
	public  void addClassgradeinfos(List<Classgradeinfo> classgradeinfos){
		save(classgradeinfos);
	}
	public  Classgradeinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Classgradeinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Classgradeinfo> queryClassGradeinfoByTime() {
		List<Classgradeinfo> classgradeinfos = findbyHql("from Classgradeinfo order by time Desc");
		return classgradeinfos;
	}
}
