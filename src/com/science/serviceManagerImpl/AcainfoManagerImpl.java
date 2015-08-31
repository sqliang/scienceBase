package com.science.serviceManagerImpl;


import com.science.domain.Acainfo;
import com.science.serviceManager.AcainfoManager;
import com.science.dao.AcainfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class AcainfoManagerImpl extends BaseManagerImpl<Acainfo> implements AcainfoManager {

	private AcainfoDao acainfoDao;

	@Autowired
	public  void setAcainfoDao(AcainfoDao acainfoDao){
		this.acainfoDao=acainfoDao;
		super.baseDao = acainfoDao;
		this.acainfoDao=acainfoDao;


	}
	public  void addAcainfo(Acainfo acainfo){
		save(acainfo);
	}
	public  void addAcainfos(List<Acainfo> acainfos){
		save(acainfos);
	}
	public  Acainfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Acainfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	
	public  List<Acainfo> queryAcainfosByTwoType(long acaType,long position){
		List<Acainfo> acainfos = findbyHql("from Acainfo where acaType=? and position=?", acaType,position);
		return acainfos;
	}
}
