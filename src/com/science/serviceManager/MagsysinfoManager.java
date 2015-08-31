package com.science.serviceManager;


import com.science.domain.Magsysinfo;
import java.util.List;

public interface MagsysinfoManager extends BaseManager<Magsysinfo> {


	public void addMagsysinfo(Magsysinfo magsysinfo);

	public void addMagsysinfos(List<Magsysinfo> magsysinfos);

	public Magsysinfo load(String sqlkey);

	public List<Magsysinfo> find(String sqlkey);
	
	public List<Magsysinfo> queryMagsysBytime();
	
	public Magsysinfo queryMagsysByid(long magsysid);

}
