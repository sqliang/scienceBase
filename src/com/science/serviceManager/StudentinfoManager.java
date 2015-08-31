package com.science.serviceManager;


import com.science.domain.Studentinfo;
import java.util.List;

public interface StudentinfoManager extends BaseManager<Studentinfo> {


	public void addStudentinfo(Studentinfo studentinfo);

	public void addStudentinfos(List<Studentinfo> studentinfos);

	public Studentinfo load(String sqlkey);

	public List<Studentinfo> find(String sqlkey);
	
	public List<Studentinfo> queryStudentsByDegree(String stuDegree);

}
