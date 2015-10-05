package com.science.serviceManagerImpl;


import com.science.domain.Introduceinfo;
import com.science.serviceManager.IntroduceinfoManager;
import com.science.dao.IntroduceinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class IntroduceinfoManagerImpl extends BaseManagerImpl<Introduceinfo> implements IntroduceinfoManager {

	private IntroduceinfoDao introduceinfoDao;

	@Autowired
	public  void setIntroduceinfoDao(IntroduceinfoDao introduceinfoDao){
		this.introduceinfoDao=introduceinfoDao;
		super.baseDao = introduceinfoDao;
		this.introduceinfoDao=introduceinfoDao;


	}
	public  void addIntroduceinfo(Introduceinfo introduceinfo){
		save(introduceinfo);
	}
	public  void addIntroduceinfos(List<Introduceinfo> introduceinfos){
		save(introduceinfos);
	}
	public  Introduceinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Introduceinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	public Introduceinfo queryLabIntrInfo(long artType){
		List<Introduceinfo> introduceinfos  = findbyHql("from Introduceinfo where artType=? order by time Desc limit 1", artType);
		Introduceinfo introduceinfo = introduceinfos.get(0);
		return introduceinfo;
	}
	@Override
	public Introduceinfo queryIntrInfoById(long artid) {
		Introduceinfo introduceinfo = introduceinfoDao.findbyHqlUnique("from Introduceinfo where artId=?", artid);
		return introduceinfo;
	};
}
