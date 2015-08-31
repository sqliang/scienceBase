package com.science.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Memberinfo;
import com.science.serviceManager.MemberinfoManager;
import com.science.util.string.StringUtil;

public class MemberManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberinfoManager memberinfoManager;
	
	private String memChengHao;
	private String memType;
	private long foreignType;
	private String memDegree;
	private List<Memberinfo> memberinfos;//返回人员
	private String target;
	
	public String getMemChangHao() {
		return memChengHao;
	}
	public void setMemChangHao(String memChengHao) {
		this.memChengHao = memChengHao;
	}
	public List<Memberinfo> getMemberinfos() {
		return memberinfos;
	}
	public void setMemberinfos(List<Memberinfo> memberinfos) {
		this.memberinfos = memberinfos;
	}
	
	public String getMemType() {
		return memType;
	}
	public void setMemType(String memType) {
		this.memType = memType;
	}
	
	public long getForeignType() {
		return foreignType;
	}
	public void setForeignType(long foreignType) {
		this.foreignType = foreignType;
	}
	
	public String getMemChengHao() {
		return memChengHao;
	}
	public void setMemChengHao(String memChengHao) {
		this.memChengHao = memChengHao;
	}
	public String getMemDegree() {
		return memDegree;
	}
	public void setMemDegree(String memDegree) {
		this.memDegree = memDegree;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	@Action(value = "/queryMemInfosByMemDegree", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_boshihou.jsp", 
					params = {"memberinfos","${memberinfos}","target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMemInfosByMemDegree(){
		try {
			target = "博士后";
			memDegree = StringUtil.convertCodeToUtf(memDegree);
			memberinfos = memberinfoManager.queryMemInfosByMemDegree(memDegree);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/queryMemInfosByForeignType", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_foreign.jsp", 
					params = {"memberinfos","${memberinfos}","target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMemInfosByForeignType(){
		try {
			target="访问学者";
			memberinfos = memberinfoManager.queryMemInfosByForeignType(foreignType);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/queryMemInfosByMemType",
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_memType.jsp", 
					params = {"memberinfos","${memberinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMemInfosByMemType(){
		try {
			memType = StringUtil.convertCodeToUtf(memType);
			memberinfos = memberinfoManager.queryMemInfosByMemType(memType);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryMemInfosBych", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_memChao.jsp", 
					params = {"memberinfos","${memberinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryMemInfosBych(){
		try {
			memChengHao = StringUtil.convertCodeToUtf(memChengHao);
			memberinfos = memberinfoManager.queryMemInfosByChengHao(memChengHao);
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryMemInfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/queryMem_admin.jsp", 
					params = {"memberinfos","${memberinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryMemInfos(){
		try {
			memberinfos = memberinfoManager.findAll();
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ERROR;
		}
	}
}
