package com.science.serviceManagerImpl;


import com.science.domain.Presentachiveinfo;
import com.science.serviceManager.PresentachiveinfoManager;
import com.science.dao.PresentachiveinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class PresentachiveinfoManagerImpl extends BaseManagerImpl<Presentachiveinfo> implements PresentachiveinfoManager {

	private PresentachiveinfoDao presentachiveinfoDao;

	@Autowired
	public  void setPresentachiveinfoDao(PresentachiveinfoDao presentachiveinfoDao){
		this.presentachiveinfoDao=presentachiveinfoDao;
		super.baseDao = presentachiveinfoDao;
		this.presentachiveinfoDao=presentachiveinfoDao;


	}
	public  void addPresentachiveinfo(Presentachiveinfo presentachiveinfo){
		save(presentachiveinfo);
	}
	public  void addPresentachiveinfos(List<Presentachiveinfo> presentachiveinfos){
		save(presentachiveinfos);
	}
	public  Presentachiveinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Presentachiveinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Presentachiveinfo> queryPresentachibeOrderByTime() {
		List<Presentachiveinfo> presentachiveinfos = findbyHql("from Presentachiveinfo order by time Desc");
		return presentachiveinfos;
	}
}
