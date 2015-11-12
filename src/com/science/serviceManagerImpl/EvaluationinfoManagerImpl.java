package com.science.serviceManagerImpl;


import com.science.domain.Evaluationinfo;
import com.science.serviceManager.EvaluationinfoManager;
import com.science.dao.EvaluationinfoDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class EvaluationinfoManagerImpl extends BaseManagerImpl<Evaluationinfo> implements EvaluationinfoManager {

	private EvaluationinfoDao evaluationinfoDao;

	@Autowired
	public  void setEvaluationinfoDao(EvaluationinfoDao evaluationinfoDao){
		this.evaluationinfoDao=evaluationinfoDao;
		super.baseDao = evaluationinfoDao;
		this.evaluationinfoDao=evaluationinfoDao;


	}
	public  void addEvaluationinfo(Evaluationinfo evaluationinfo){
		save(evaluationinfo);
	}
	public  void addEvaluationinfos(List<Evaluationinfo> evaluationinfos){
		save(evaluationinfos);
	}
	public  Evaluationinfo load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Evaluationinfo> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Evaluationinfo> queryEvaluationBytime() {
		List<Evaluationinfo> evaluationinfos = findbyHql("from Evaluationinfo order by time Desc");
		return evaluationinfos;
	}
	@Override
	public Evaluationinfo queryEvaluationById(long evaluationId) {
		Evaluationinfo evaluationinfo = evaluationinfoDao.findbyHqlUnique("from Evaluationinfo where evaluationId=?", evaluationId);
		return evaluationinfo;
	}
}
