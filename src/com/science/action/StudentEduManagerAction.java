package com.science.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Classgradeinfo;
import com.science.domain.Classinfo;
import com.science.domain.Studentinfo;
import com.science.serviceManager.ClassgradeinfoManager;
import com.science.serviceManager.ClassinfoManager;
import com.science.serviceManager.StudentinfoManager;

public class StudentEduManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private StudentinfoManager studentinfoManager;
	@Autowired
	private ClassinfoManager classinfoManager;
	@Autowired
	private ClassgradeinfoManager classgradeinfoManager;
	
	private String stuDegree;
	private List<Studentinfo> studentinfos;
	private List<Classinfo> classinfos;
	private List<Classgradeinfo> classgradeinfos;
	private String target;
	private Studentinfo studentinfo;
	private Classinfo classinfo;
	private Classgradeinfo classgradeinfo;
	
	public String getStuDegree() {
		return stuDegree;
	}
	public void setStuDegree(String stuDegree) {
		this.stuDegree = stuDegree;
	}
	public List<Studentinfo> getStudentinfos() {
		return studentinfos;
	}
	public void setStudentinfos(List<Studentinfo> studentinfos) {
		this.studentinfos = studentinfos;
	}
	public List<Classinfo> getClassinfos() {
		return classinfos;
	}
	public void setClassinfos(List<Classinfo> classinfos) {
		this.classinfos = classinfos;
	}
	public List<Classgradeinfo> getClassgradeinfos() {
		return classgradeinfos;
	}
	public void setClassgradeinfos(List<Classgradeinfo> classgradeinfos) {
		this.classgradeinfos = classgradeinfos;
	}
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	public Studentinfo getStudentinfo() {
		return studentinfo;
	}
	public void setStudentinfo(Studentinfo studentinfo) {
		this.studentinfo = studentinfo;
	}
	public Classinfo getClassinfo() {
		return classinfo;
	}
	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}
	public Classgradeinfo getClassgradeinfo() {
		return classgradeinfo;
	}
	public void setClassgradeinfo(Classgradeinfo classgradeinfo) {
		this.classgradeinfo = classgradeinfo;
	}
	@Action(value = "/queryClassGradeinfoByTime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_classgrade.jsp", 
					params = {"classgradeinfos","${classgradeinfos}","target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryClassGradeinfoByTime(){
		try {
			target = "教学成果";
			classgradeinfos = classgradeinfoManager.queryClassGradeinfoByTime();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryClassinfoByTime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_classinfo.jsp", 
					params = {"classinfos","${classinfos}",
							  "target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryClassinfoByTime(){
		try {
			target="主讲课程";
			classinfos = classinfoManager.queryClassinfoByTime();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryStudentsByDegree", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/detail.jsp", 
					params = {"studentinfos","${studentinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryStudentsByDegree(){
		try {
			studentinfos = studentinfoManager.queryStudentsByDegree(stuDegree);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryStudentEdu", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/queryStudent_admin.jsp", 
					params = {"studentinfos","${studentinfos}","classinfos","${classinfos}",
							  "classgradeinfos","${classgradeinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryStudentEdu(){
		try {
			studentinfos = studentinfoManager.findAll();//学生信息
			classinfos = classinfoManager.queryClassinfoByTime();
			classgradeinfos = classgradeinfoManager.queryClassGradeinfoByTime();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addStudentInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addPersonEdu_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addStudentInfo(){
		try {
			/*introduceinfo.setTime(new Date(System.currentTimeMillis()));*/
			studentinfoManager.save(studentinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addClassInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addPersonEdu_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addClassInfo(){
		try {
			classinfo.setTime(new Date(System.currentTimeMillis()));
			classinfoManager.save(classinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addClassGradeInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addPersonEdu_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addClassGradeInfo(){
		try {
			classgradeinfoManager.save(classgradeinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
}
