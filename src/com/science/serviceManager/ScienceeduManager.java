package com.science.serviceManager;


import com.science.domain.Scienceedu;
import java.util.List;

public interface ScienceeduManager extends BaseManager<Scienceedu> {


	public void addScienceedu(Scienceedu scienceedu);

	public void addScienceedus(List<Scienceedu> scienceedus);

	public Scienceedu load(String sqlkey);

	public List<Scienceedu> find(String sqlkey);
	
	public List<Scienceedu> queryScienceeduByTime();
}
