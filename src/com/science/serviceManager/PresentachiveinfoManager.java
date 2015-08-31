package com.science.serviceManager;


import com.science.domain.Presentachiveinfo;
import java.util.List;

public interface PresentachiveinfoManager extends BaseManager<Presentachiveinfo> {


	public void addPresentachiveinfo(Presentachiveinfo presentachiveinfo);

	public void addPresentachiveinfos(List<Presentachiveinfo> presentachiveinfos);

	public Presentachiveinfo load(String sqlkey);

	public List<Presentachiveinfo> find(String sqlkey);
	
	public List<Presentachiveinfo> queryPresentachibeOrderByTime();

}
