package com.science.serviceManagerImpl;


import com.science.domain.Projectinfo;
import com.science.serviceManager.ProjectinfoManager;
import com.science.dao.ProjectinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class ProjectinfoManagerImpl extends BaseManagerImpl<Projectinfo> implements ProjectinfoManager {

	private ProjectinfoDao projectinfoDao;

	@Autowired
	public  void setProjectinfoDao(ProjectinfoDao projectinfoDao){
		this.projectinfoDao=projectinfoDao;
		super.baseDao = projectinfoDao;
		this.projectinfoDao=projectinfoDao;


	}
	public  void addProjectinfo(Projectinfo projectinfo){
		save(projectinfo);
	}
	public  void addProjectinfos(List<Projectinfo> projectinfos){
		save(projectinfos);
	}
	public  Projectinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Projectinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Projectinfo> queryProjectOrderBytime() {
		List<Projectinfo> projectinfos = findbyHql("from Projectinfo order by time Desc");
		return projectinfos;
	}
	@Override
	public List<Projectinfo> queryProjectByFenye(long start,long limit) {
		List<Projectinfo> projectinfos = projectinfoDao.findByHqlP("from Projectinfo order by time Desc", (int)start, (int)limit);
		return projectinfos;
	}
}
