package com.science.serviceManager;


import com.science.domain.Leaderinfo;
import java.util.List;

public interface LeaderinfoManager extends BaseManager<Leaderinfo> {


	public void addLeaderinfo(Leaderinfo leaderinfo);

	public void addLeaderinfos(List<Leaderinfo> leaderinfos);

	public Leaderinfo load(String sqlkey);

	public List<Leaderinfo> find(String sqlkey);
	
	public List<Leaderinfo> queryLeaderinfosByTwoType(long leaderType,long position);
	
	public List<Leaderinfo> queryLeaderinfos();
}
