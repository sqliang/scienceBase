package com.science.serviceManagerImpl;


import com.science.domain.Leaderinfo;
import com.science.serviceManager.LeaderinfoManager;
import com.science.dao.LeaderinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class LeaderinfoManagerImpl extends BaseManagerImpl<Leaderinfo> implements LeaderinfoManager {

	private LeaderinfoDao leaderinfoDao;

	@Autowired
	public  void setLeaderinfoDao(LeaderinfoDao leaderinfoDao){
		this.leaderinfoDao=leaderinfoDao;
		super.baseDao = leaderinfoDao;
		this.leaderinfoDao=leaderinfoDao;


	}
	public  void addLeaderinfo(Leaderinfo leaderinfo){
		save(leaderinfo);
	}
	public  void addLeaderinfos(List<Leaderinfo> leaderinfos){
		save(leaderinfos);
	}
	public  Leaderinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Leaderinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	
	@Override
	public List<Leaderinfo> queryLeaderinfosByTwoType(long leaderType,
			long position) {
		List<Leaderinfo> leaderinfos = findbyHql("from Leaderinfo where leadertype=? and position=?", leaderType,position);
		for(Leaderinfo leaderinfo : leaderinfos){
			leaderinfo.loadMemberinfomemid();
		}
		return leaderinfos;
	}
	@Override
	public List<Leaderinfo> queryLeaderinfos() {
		List<Leaderinfo> leaderinfos = findAll();
		for(Leaderinfo leaderinfo : leaderinfos){
			leaderinfo.loadMemberinfomemid();
		}
		return leaderinfos;
	}
}
