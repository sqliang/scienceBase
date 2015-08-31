package com.science.action;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Null;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Communicateinfo;
import com.science.domain.Pubclassinfo;
import com.science.serviceManager.CommunicateinfoManager;
import com.science.serviceManager.PubclassinfoManager;

public class CommunicateManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CommunicateinfoManager communicateinfoManager;
	@Autowired
	private PubclassinfoManager pubclassinfoManager;
	
	private List<Communicateinfo> communicateinfos;
	private List<Pubclassinfo> pubclassinfos;
	private long communicateType;
	private String target;
	private Communicateinfo communicateinfo;
	private Pubclassinfo pubclassinfo;
	
	public List<Communicateinfo> getCommunicateinfos() {
		return communicateinfos;
	}
	public void setCommunicateinfos(List<Communicateinfo> communicateinfos) {
		this.communicateinfos = communicateinfos;
	}
	public List<Pubclassinfo> getPubclassinfos() {
		return pubclassinfos;
	}
	public void setPubclassinfos(List<Pubclassinfo> pubclassinfos) {
		this.pubclassinfos = pubclassinfos;
	}
	public long getCommunicateType() {
		return communicateType;
	}
	public void setCommunicateType(long communicateType) {
		this.communicateType = communicateType;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Communicateinfo getCommunicateinfo() {
		return communicateinfo;
	}
	public void setCommunicateinfo(Communicateinfo communicateinfo) {
		this.communicateinfo = communicateinfo;
	}
	public Pubclassinfo getPubclassinfo() {
		return pubclassinfo;
	}
	public void setPubclassinfo(Pubclassinfo pubclassinfo) {
		this.pubclassinfo = pubclassinfo;
	}
	
	@Action(value = "/queryCommuicateByType", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_communicate.jsp", 
					params = {"communicateinfos","${communicateinfos}","target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryCommuicateByType(){
		try {
			communicateinfos = communicateinfoManager.queryCommuicateByType(communicateType);
			if(communicateinfos != null){
				long commType = communicateinfos.get(0).getCommunicatetype();
				if(commType == 1){
					target = "国内交流";
				}else{
					target = "国际交流";
				}
			}
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryPubclassBytime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_pubclass.jsp", 
					params = {"pubclassinfos","${pubclassinfos}","target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryPubclassBytime(){
		try {
			target="开放课题";
			pubclassinfos = pubclassinfoManager.queryPubclassBytime();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryComunicate", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/queryCommunicate_admin.jsp", 
					params = {"communicateinfos","${communicateinfos}","pubclassinfos","${pubclassinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryComunicate(){
		try {
			communicateinfos = communicateinfoManager.queryCommuicateByTime();
			pubclassinfos = pubclassinfoManager.queryPubclassBytime();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addCommunicateinfo",
			results = {
				@Result(name = "success", type = "dispatcher", location = "/admin/addCommunicate_admin.jsp",
						params = {}),
						@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
						params = {"msg","${msg}"})})
	public String addCommunicateinfo(){
		try {
			communicateinfo.setTime(new Date(System.currentTimeMillis()));
			communicateinfoManager.save(communicateinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addPubclassinfo",
			results = {
				@Result(name = "success", type = "dispatcher", location = "/admin/addCommunicate_admin.jsp",
						params = {}),
				@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
						params = {"msg","${msg}"})})
	public String addPubclassinfo(){
		try {
			pubclassinfo.setTime(new Date(System.currentTimeMillis()));
			pubclassinfoManager.save(pubclassinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	 }



	
}
