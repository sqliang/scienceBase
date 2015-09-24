package com.science.serviceManager;


import com.science.domain.Resdirection;
import java.util.List;

public interface ResdirectionManager extends BaseManager<Resdirection> {


	public void addResdirection(Resdirection resdirection);

	public void addResdirections(List<Resdirection> resdirections);

	public Resdirection load(String sqlkey);

	public List<Resdirection> find(String sqlkey);
	
	public List<Resdirection> findAllOrderyByTime();
	
	public Resdirection queryResdirById(long dirId);

}
