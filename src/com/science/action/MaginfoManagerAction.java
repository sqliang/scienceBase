package com.science.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Evaluationinfo;
import com.science.domain.Magsysinfo;
import com.science.serviceManager.EvaluationinfoManager;
import com.science.serviceManager.JManager;
import com.science.serviceManager.MagsysinfoManager;
import com.science.serviceManager.SubmenuManager;
import com.science.util.string.StringUtil;

public class MaginfoManagerAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private MagsysinfoManager magsysinfoManager;
	@Autowired
	private EvaluationinfoManager evaluationinfoManager;
	@Autowired
	private SubmenuManager submenuManager;
	@Autowired
	private JManager jManager;
	
	private List<Evaluationinfo> evaluationinfos;
	private List<Magsysinfo> magsysinfos;
	private String subMenuName;
	private long mainMenuId;
	private Magsysinfo magsysinfo;
	private long magsysid;
	private String pageNow;
	private long limit;
	private long start;
	private long totalPages;
	
	private  Evaluationinfo evaluationinfo;
	private String evaluationId;
	
	public List<Evaluationinfo> getEvaluationinfos() {
		return evaluationinfos;
	}
	public void setEvaluationinfos(List<Evaluationinfo> evaluationinfos) {
		this.evaluationinfos = evaluationinfos;
	}
	public List<Magsysinfo> getMagsysinfos() {
		return magsysinfos;
	}
	public void setMagsysinfos(List<Magsysinfo> magsysinfos) {
		this.magsysinfos = magsysinfos;
	}
	
	public Magsysinfo getMagsysinfo() {
		return magsysinfo;
	}
	public void setMagsysinfo(Magsysinfo magsysinfo) {
		this.magsysinfo = magsysinfo;
	}
	public long getMagsysid() {
		return magsysid;
	}
	public void setMagsysid(long magsysid) {
		this.magsysid = magsysid;
	}
	public Evaluationinfo getEvaluationinfo() {
		return evaluationinfo;
	}
	public void setEvaluationinfo(Evaluationinfo evaluationinfo) {
		this.evaluationinfo = evaluationinfo;
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
	public String getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(String evaluationId) {
		this.evaluationId = evaluationId;
	}
	@Action(value = "/queryEvaluationBytime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_evaluate.jsp", 
					params = {"evaluationinfos","${evaluationinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryEvaluationBytime(){
		try {
			evaluationinfos = evaluationinfoManager.queryEvaluationBytime();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryMagsysByTime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_magsys.jsp", 
					params = {"magsysinfos","${magsysinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}","totalPages","${totalPages}",
							  "pageNow","${pageNow}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMagsysByTime(){
		try {
			long totalCount = Long.parseLong(jManager.simpleSQL("select count(*) from magsysinfo"));
			limit = 10;
			start = (Integer.parseInt(pageNow) - 1)*limit;
			totalPages = (totalCount + limit -1)/limit;
			magsysinfos =  magsysinfoManager.querMagsysFenyeByTime(start, limit);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryMag", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/queryMagInfo_admin.jsp", 
					params = {"evaluationinfos","${evaluationinfos}","magsysinfos","${magsysinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryMag(){
		try {
			evaluationinfos = evaluationinfoManager.queryEvaluationBytime();
			magsysinfos = magsysinfoManager.queryMagsysBytime();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/queryMagsysByid", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/detail_magsys.jsp", 
					params = {"magsysinfo","${magsysinfo}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMagsysByid(){
		try {
			magsysinfo = magsysinfoManager.queryMagsysByid(magsysid);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addEvaluationinfo",
			results = {
				@Result(name = "success", type = "dispatcher", location = "/admin/addMag_admin.jsp",
						params = {}),
				@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
						params = {"msg","${msg}"})})
	public String addEvaluationinfo(){
		try {
			evaluationinfo.setTime(new Date(System.currentTimeMillis()));
			evaluationinfoManager.save(evaluationinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/delEvaluationinfoByid", 
			results = { 
			@Result(name = "success", type = "redirect", location = "/adminQueryMag"),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String delEvaluationinfoByid(){
		try {
			evaluationinfoManager.deletebyProperty("evaluationId", evaluationId);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	@Action(value = "addMagsysinfo",
			results = {
				@Result(name = "success", type = "dispatcher", location = "/admin/addMag_admin.jsp",
						params = {}),
				@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
						params = {"msg","${msg}"})})
	public String addMagsysinfo(){
		try {
			magsysinfoManager.save(magsysinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/delMagsysByid", 
			results = { 
			@Result(name = "success", type = "redirect", location = "/adminQueryMag"),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String delMagsysByid(){
		try {
			magsysinfoManager.deletebyProperty("magSysId", magsysid);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
