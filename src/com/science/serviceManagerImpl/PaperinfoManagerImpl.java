package com.science.serviceManagerImpl;


import com.science.domain.Paperinfo;
import com.science.serviceManager.PaperinfoManager;
import com.science.dao.PaperinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class PaperinfoManagerImpl extends BaseManagerImpl<Paperinfo> implements PaperinfoManager {

	private PaperinfoDao paperinfoDao;

	@Autowired
	public  void setPaperinfoDao(PaperinfoDao paperinfoDao){
		this.paperinfoDao=paperinfoDao;
		super.baseDao = paperinfoDao;
		this.paperinfoDao=paperinfoDao;


	}
	public  void addPaperinfo(Paperinfo paperinfo){
		save(paperinfo);
	}
	public  void addPaperinfos(List<Paperinfo> paperinfos){
		save(paperinfos);
	}
	public  Paperinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Paperinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Paperinfo> queryPaperOrderByTime() {
		List<Paperinfo> paperinfos = findbyHql("from Paperinfo order by time Desc");
		return paperinfos;
	}
}
