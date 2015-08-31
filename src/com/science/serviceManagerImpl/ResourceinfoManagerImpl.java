package com.science.serviceManagerImpl;


import com.science.domain.Resourceinfo;
import com.science.serviceManager.ResourceinfoManager;
import com.science.dao.ResourceinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class ResourceinfoManagerImpl extends BaseManagerImpl<Resourceinfo> implements ResourceinfoManager {

	private ResourceinfoDao resourceinfoDao;

	@Autowired
	public  void setResourceinfoDao(ResourceinfoDao resourceinfoDao){
		this.resourceinfoDao=resourceinfoDao;
		super.baseDao = resourceinfoDao;
		this.resourceinfoDao=resourceinfoDao;


	}
	public  void addResourceinfo(Resourceinfo resourceinfo){
		save(resourceinfo);
	}
	public  void addResourceinfos(List<Resourceinfo> resourceinfos){
		save(resourceinfos);
	}
	public  Resourceinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Resourceinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Resourceinfo> queryResourceByType(long resourceType) {
		List<Resourceinfo> resourceinfos = findByProperty("resourcetype", resourceType);
		return resourceinfos;
	}
	@Override
	public List<Resourceinfo> queryResourceByTime() {
		List<Resourceinfo> resourceinfos = findbyHql("from Resourceinfo order by time Desc");
		return resourceinfos;
	}
}
