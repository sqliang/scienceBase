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
import com.science.serviceManager.JManager;
import com.science.serviceManager.StudentinfoManager;
import com.science.serviceManager.SubmenuManager;
import com.science.util.string.StringUtil;

public class StudentEduManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private StudentinfoManager studentinfoManager;
	@Autowired
	private ClassinfoManager classinfoManager;
	@Autowired
	private ClassgradeinfoManager classgradeinfoManager;
	@Autowired
	private SubmenuManager submenuManager;
	@Autowired
	private JManager jManager;
	
	private String stuDegree;
	private List<Studentinfo> studentinfos;
	private List<Classinfo> classinfos;
	private List<Classgradeinfo> classgradeinfos;
	private String subMenuName;
	private long mainMenuId;
	private Studentinfo studentinfo;
	private Classinfo classinfo;
	private Classgradeinfo classgradeinfo;
	
	private String pageNow;
	private long limit;
	private long start;
	private long totalPages;
	
	private String stuId;
	private String classId;
	private String gradeId;
	
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
	
	public String getSubMenuName() {
		return subMenuName;
	}
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}
	public long getMainMenuId() {
		return mainMenuId;
	}
	public void setMainMenuId(long mainMenuId) {
		this.mainMenuId = mainMenuId;
	}
	public String getPageNow() {
		return pageNow;
	}
	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}
	public long getLimit() {
		return limit;
	}
	public void setLimit(long limit) {
		this.limit = limit;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	@Action(value = "/queryClassGradeinfoByTime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_classgrade.jsp", 
					params = {"classgradeinfos","${classgradeinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryClassGradeinfoByTime(){
		try {
			classgradeinfos = classgradeinfoManager.queryClassGradeinfoByTime();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryClassinfoByTime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_classinfo.jsp", 
					params = {"classinfos","${classinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryClassinfoByTime(){
		try {
			classinfos = classinfoManager.queryClassinfoByTime();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryStudentsByDegree", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_students.jsp", 
					params = {"studentinfos","${studentinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}","totalPages","${totalPages}",
							  "pageNow","${pageNow}","stuDegree","${stuDegree}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryStudentsByDegree(){
		try {
			stuDegree = StringUtil.convertCodeToUtf(stuDegree);
			long totalCount = Long.parseLong(jManager.simpleSQL("select count(*) from studentinfo where stuDegree=?",stuDegree));
			limit = 20;
			start = (Integer.parseInt(pageNow) - 1)*limit;
			totalPages = (totalCount + limit -1)/limit;
			studentinfos = studentinfoManager.queryStudentByFenye(stuDegree,start, limit);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryStudentEdu", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/queryStudent_admin.jsp", 
					params = {"studentinfos","${studentinfos}","classinfos","${classinfos}",
							  "classgradeinfos","${classgradeinfos}",
							  "totalPages","${totalPages}","pageNow","${pageNow}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryStudentEdu(){
		try {
			long totalCount = Long.parseLong(jManager.simpleSQL("select count(*) from studentinfo"));
			limit = 20;
			start = (Integer.parseInt(pageNow) - 1)*limit;
			totalPages = (totalCount + limit -1)/limit;
			studentinfos = studentinfoManager.adminQueryStudent(start, limit);
			classinfos = classinfoManager.queryClassinfoByTime();
			classgradeinfos = classgradeinfoManager.queryClassGradeinfoByTime();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
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
	
	@Action(value = "delStudentInfoById", 
			results = { 
			@Result(name = "success", type = "redirect", location = "/adminQueryStudentEdu", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String delStudentInfoById(){
		try {
			studentinfoManager.deletebyProperty("stuId", stuId);
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
	
	@Action(value = "delClassinfoById", 
			results = { 
			@Result(name = "success", type = "redirect", location = "/adminQueryStudentEdu", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String delClassinfoById(){
		try {
			classinfoManager.deletebyProperty("classId", classId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "delClassGradeInfoById", 
			results = { 
			@Result(name = "success", type = "redirect", location = "/adminQueryStudentEdu", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String delClassGradeInfoById(){
		try {
			classgradeinfoManager.deletebyProperty("gradeId", gradeId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
