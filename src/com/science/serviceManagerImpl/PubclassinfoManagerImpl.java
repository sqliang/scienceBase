package com.science.serviceManagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.science.dao.PubclassinfoDao;
import com.science.domain.Pubclassinfo;
import com.science.serviceManager.PubclassinfoManager;

@Component
public class PubclassinfoManagerImpl extends BaseManagerImpl<Pubclassinfo> implements PubclassinfoManager {
	private PubclassinfoDao pubclassinfoDao;
	@Autowired
	public void setPubclassinfoDao(PubclassinfoDao pubclassinfoDao){
		this.pubclassinfoDao=pubclassinfoDao;
		super.baseDao = pubclassinfoDao;
		this.pubclassinfoDao=pubclassinfoDao;
	}
	@Override
	public void addPubclassinfo(Pubclassinfo pubclassinfo) {
		save(pubclassinfo);
	}

	@Override
	public void addPubclassinfos(List<Pubclassinfo> pubclassinfos) {
		save(pubclassinfos);
	}

	@Override
	public Pubclassinfo load(String sqlkey) {
		return findbyHqlUnique(sqlkey);
	}

	@Override
	public List<Pubclassinfo> find(String sqlkey) {
		return findbyHql(sqlkey);
	}
	@Override
	public List<Pubclassinfo> queryPubclassBytime() {
		List<Pubclassinfo> pubclassinfos = findbyHql("from Pubclassinfo order by time Desc");
		return pubclassinfos;
	}

}
