package com.science.serviceManagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.science.dao.AcainfoDao;
import com.science.dao.CommunicateinfoDao;
import com.science.domain.Communicateinfo;
import com.science.serviceManager.CommunicateinfoManager;

@Component
public class CommunicateinfoManagerImpl extends BaseManagerImpl<Communicateinfo> implements CommunicateinfoManager {
	
	private CommunicateinfoDao communicateinfoDao;
	
	@Autowired
	public  void setCommunicateinfoDao(CommunicateinfoDao communicateinfoDao){
		this.communicateinfoDao=communicateinfoDao;
		super.baseDao = communicateinfoDao;
		this.communicateinfoDao=communicateinfoDao;


	}

	@Override
	public void addCommunicateinfo(Communicateinfo communicateinfo) {
		save(communicateinfo);
	}

	@Override
	public void addCommunicateinfos(List<Communicateinfo> communicateinfos) {
		save(communicateinfos);
	}

	@Override
	public Communicateinfo load(String sqlkey) {
		return findbyHqlUnique(sqlkey);
	}

	@Override
	public List<Communicateinfo> find(String sqlkey) {
		return findbyHql(sqlkey);
	}
	@Override
	public List<Communicateinfo> queryCommuicateByType(long communicateType,long start, long limit) {
		List<Communicateinfo> communicateinfos = communicateinfoDao.findByHqlP("from Communicateinfo where communicateType=? order by time", (int)start, (int)limit, communicateType);
		return communicateinfos;
	}

	@Override
	public List<Communicateinfo> queryCommuicateByTime() {
		List<Communicateinfo> communicateinfos  = findbyHql("from Communicateinfo order by time Desc");
		return communicateinfos;
	}

	
	
}
