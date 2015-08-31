package com.science.serviceManager;


import com.science.domain.Evaluationinfo;
import java.util.List;

public interface EvaluationinfoManager extends BaseManager<Evaluationinfo> {


	public void addEvaluationinfo(Evaluationinfo evaluationinfo);

	public void addEvaluationinfos(List<Evaluationinfo> evaluationinfos);

	public Evaluationinfo load(String sqlkey);

	public List<Evaluationinfo> find(String sqlkey);
	
	public List<Evaluationinfo> queryEvaluationBytime();
}
