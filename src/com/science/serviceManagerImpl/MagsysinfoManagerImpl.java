package com.science.serviceManagerImpl;


import com.science.domain.Magsysinfo;
import com.science.serviceManager.MagsysinfoManager;
import com.science.dao.MagsysinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class MagsysinfoManagerImpl extends BaseManagerImpl<Magsysinfo> implements MagsysinfoManager {

	private MagsysinfoDao magsysinfoDao;

	@Autowired
	public  void setMagsysinfoDao(MagsysinfoDao magsysinfoDao){
		this.magsysinfoDao=magsysinfoDao;
		super.baseDao = magsysinfoDao;
		this.magsysinfoDao=magsysinfoDao;


	}
	public  void addMagsysinfo(Magsysinfo magsysinfo){
		save(magsysinfo);
	}
	public  void addMagsysinfos(List<Magsysinfo> magsysinfos){
		save(magsysinfos);
	}
	public  Magsysinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Magsysinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Magsysinfo> queryMagsysBytime() {
		List<Magsysinfo> magsysinfos = findbyHql("from Magsysinfo order by time Desc");
		return magsysinfos;
	}
	@Override
	public Magsysinfo queryMagsysByid(long magsysid) {
		Magsysinfo magsysinfo = findByPropertyUnique("magsysid",magsysid);
		return magsysinfo;
	}
	
}
