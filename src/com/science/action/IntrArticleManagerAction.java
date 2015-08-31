package com.science.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Introduceinfo;
import com.science.domain.Picnews;
import com.science.serviceManager.IntroduceinfoManager;

public class IntrArticleManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private IntroduceinfoManager introduceinfoManager;
	
	private Introduceinfo introduceinfo;//概况
	private List<Introduceinfo> introduceinfos;
	private long artType;
	
	public Introduceinfo getIntroduceinfo() {
		return introduceinfo;
	}
	public void setIntroduceinfo(Introduceinfo introduceinfo) {
		this.introduceinfo = introduceinfo;
	}
	public long getArtType() {
		return artType;
	}
	public void setArtType(long artType) {
		this.artType = artType;
	}
	
	public List<Introduceinfo> getIntroduceinfos() {
		return introduceinfos;
	}
	public void setIntroduceinfos(List<Introduceinfo> introduceinfos) {
		this.introduceinfos = introduceinfos;
	}
	
	@Action(value = "/queryIntrInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/person_edu_detail.jsp", 
					params = {"introduceinfo","${introduceinfo}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryIntrInfo(){
		try {
			introduceinfo = introduceinfoManager.queryLabIntrInfo(artType);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryIntrInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/queryArt_admin.jsp", 
					params = {"introduceinfos","${introduceinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryIntrInfo(){
		try {
			introduceinfos = introduceinfoManager.findAll();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "addIntrInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addInfo_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addIntrInfo(){
		try {
			introduceinfo.setTime(new Date(System.currentTimeMillis()));
			introduceinfoManager.save(introduceinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

}
