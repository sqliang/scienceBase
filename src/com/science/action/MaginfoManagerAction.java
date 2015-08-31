package com.science.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Evaluationinfo;
import com.science.domain.Magsysinfo;
import com.science.serviceManager.EvaluationinfoManager;
import com.science.serviceManager.MagsysinfoManager;

public class MaginfoManagerAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private MagsysinfoManager magsysinfoManager;
	@Autowired
	private EvaluationinfoManager evaluationinfoManager;
	
	private List<Evaluationinfo> evaluationinfos;
	private List<Magsysinfo> magsysinfos;
	private String target;
	private Magsysinfo magsysinfo;
	private long magsysid;
	
	private  Evaluationinfo evaluationinfo;
	
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
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
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
	
	@Action(value = "/queryEvaluationBytime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_evaluate.jsp", 
					params = {"evaluationinfos","${evaluationinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryEvaluationBytime(){
		try {
			target = "考核报告";
			evaluationinfos = evaluationinfoManager.queryEvaluationBytime();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryMagsysByTime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_magsys.jsp", 
					params = {"magsysinfos","${magsysinfos}","target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMagsysByTime(){
		try {
			target="管理制度";
			magsysinfos = magsysinfoManager.queryMagsysBytime();
			return SUCCESS;
		} catch (Exception e) {
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
}
