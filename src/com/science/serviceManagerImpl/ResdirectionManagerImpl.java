package com.science.serviceManagerImpl;


import com.science.domain.Resdirection;
import com.science.serviceManager.ResdirectionManager;
import com.science.dao.ResdirectionDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class ResdirectionManagerImpl extends BaseManagerImpl<Resdirection> implements ResdirectionManager {

	private ResdirectionDao resdirectionDao;

	@Autowired
	public  void setResdirectionDao(ResdirectionDao resdirectionDao){
		this.resdirectionDao=resdirectionDao;
		super.baseDao = resdirectionDao;
		this.resdirectionDao=resdirectionDao;


	}
	public  void addResdirection(Resdirection resdirection){
		save(resdirection);
	}
	public  void addResdirections(List<Resdirection> resdirections){
		save(resdirections);
	}
	public  Resdirection load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Resdirection> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Resdirection> findAllOrderyByTime() {
		List<Resdirection> resdirections = findbyHql("from Resdirection order by time Desc");
		return resdirections;
	}
	@Override
	public Resdirection queryResdirById(long dirId) {
		Resdirection resdirection = findbyHqlUnique("from Resdirection where dirId=?", dirId);
		return resdirection;
	}
	
	
}
