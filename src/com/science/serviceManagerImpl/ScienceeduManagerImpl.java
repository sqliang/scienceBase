package com.science.serviceManagerImpl;


import com.science.domain.Scienceedu;
import com.science.serviceManager.ScienceeduManager;
import com.science.dao.ScienceeduDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class ScienceeduManagerImpl extends BaseManagerImpl<Scienceedu> implements ScienceeduManager {

	private ScienceeduDao scienceeduDao;

	@Autowired
	public  void setScienceeduDao(ScienceeduDao scienceeduDao){
		this.scienceeduDao=scienceeduDao;
		super.baseDao = scienceeduDao;
		this.scienceeduDao=scienceeduDao;


	}
	public  void addScienceedu(Scienceedu scienceedu){
		save(scienceedu);
	}
	public  void addScienceedus(List<Scienceedu> scienceedus){
		save(scienceedus);
	}
	public  Scienceedu load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Scienceedu> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Scienceedu> queryScienceeduByTime() {
		List<Scienceedu> scienceedus = findbyHql("from Scienceedu order by time Desc");
		return scienceedus;
	}
}
