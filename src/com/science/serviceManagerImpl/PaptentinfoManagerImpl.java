package com.science.serviceManagerImpl;


import com.science.domain.Paptentinfo;
import com.science.serviceManager.PaptentinfoManager;
import com.science.dao.PaptentinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class PaptentinfoManagerImpl extends BaseManagerImpl<Paptentinfo> implements PaptentinfoManager {

	private PaptentinfoDao paptentinfoDao;

	@Autowired
	public  void setPaptentinfoDao(PaptentinfoDao paptentinfoDao){
		this.paptentinfoDao=paptentinfoDao;
		super.baseDao = paptentinfoDao;
		this.paptentinfoDao=paptentinfoDao;


	}
	public  void addPaptentinfo(Paptentinfo paptentinfo){
		save(paptentinfo);
	}
	public  void addPaptentinfos(List<Paptentinfo> paptentinfos){
		save(paptentinfos);
	}
	public  Paptentinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Paptentinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Paptentinfo> queryPaptentOrderByTime() {
		List<Paptentinfo> paptentinfos = findbyHql("from Paptentinfo order by agreetime Desc");
		return paptentinfos;
	}
}
