package com.science.serviceManager;


import com.science.domain.Paperinfo;
import java.util.List;

public interface PaperinfoManager extends BaseManager<Paperinfo> {


	public void addPaperinfo(Paperinfo paperinfo);

	public void addPaperinfos(List<Paperinfo> paperinfos);

	public Paperinfo load(String sqlkey);

	public List<Paperinfo> find(String sqlkey);
	
	public List<Paperinfo> queryPaperOrderByTime();
	
	public List<Paperinfo> queryPaperByFenye(long start,long limit);

}
