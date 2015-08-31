package com.science.serviceManagerImpl;


import com.science.domain.Labgradeinfo;
import com.science.serviceManager.LabgradeinfoManager;
import com.science.dao.LabgradeinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class LabgradeinfoManagerImpl extends BaseManagerImpl<Labgradeinfo> implements LabgradeinfoManager {

	private LabgradeinfoDao labgradeinfoDao;

	@Autowired
	public  void setLabgradeinfoDao(LabgradeinfoDao labgradeinfoDao){
		this.labgradeinfoDao=labgradeinfoDao;
		super.baseDao = labgradeinfoDao;
		this.labgradeinfoDao=labgradeinfoDao;


	}
	public  void addLabgradeinfo(Labgradeinfo labgradeinfo){
		save(labgradeinfo);
	}
	public  void addLabgradeinfos(List<Labgradeinfo> labgradeinfos){
		save(labgradeinfos);
	}
	public  Labgradeinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Labgradeinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Labgradeinfo> queryLabGradeOrderByTime() {
		List<Labgradeinfo> labgradeinfos = findbyHql("from Labgradeinfo order by time Desc");
		return labgradeinfos;
	}
}
