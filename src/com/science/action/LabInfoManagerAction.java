package com.science.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Acainfo;
import com.science.domain.Leaderinfo;
import com.science.domain.Memberinfo;
import com.science.domain.Organization;
import com.science.domain.Resdirection;
import com.science.serviceManager.AcainfoManager;
import com.science.serviceManager.LeaderinfoManager;
import com.science.serviceManager.OrganizationManager;
import com.science.serviceManager.ResdirectionManager;

public class LabInfoManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ResdirectionManager resdirectionManager;
	@Autowired
	private OrganizationManager organizationManager;
	@Autowired
	private LeaderinfoManager leaderinfoManager;
	@Autowired
	private AcainfoManager acainfoManager;
	
	private List<Resdirection> resdirections; //研究方向
	private List<Organization> organizations;//机构设置
	private List<Leaderinfo> masterPersNow;//主任
	private List<Leaderinfo> fuZhuRensNow;//副主任
	private List<Leaderinfo> miShuNow;
	private List<Leaderinfo> masterPersPast;//主任
	private List<Leaderinfo> fuZhuRensPast;//副主任
	private List<Leaderinfo> miShuPast;
	private List<Acainfo> materAcasNow;
	private List<Acainfo> fuAcasNow;
	private List<Acainfo> singleAcasNow;
	private List<Acainfo> materAcasPast;
	private List<Acainfo> fuAcasPast;
	private List<Acainfo> singleAcasPast;
	private String target;
	private List<Leaderinfo> leaderinfos;
	private List<Acainfo> acainfos;
	
	private Resdirection resdirection;
	private Organization organization;
	private Leaderinfo leaderinfo;
	private Acainfo acainfo;
	

	public List<Resdirection> getResdirections() {
		return resdirections;
	}

	public void setResdirections(List<Resdirection> resdirections) {
		this.resdirections = resdirections;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public List<Leaderinfo> getMasterPersNow() {
		return masterPersNow;
	}

	public void setMasterPersNow(List<Leaderinfo> masterPersNow) {
		this.masterPersNow = masterPersNow;
	}

	public List<Leaderinfo> getFuZhuRensNow() {
		return fuZhuRensNow;
	}

	public void setFuZhuRensNow(List<Leaderinfo> fuZhuRensNow) {
		this.fuZhuRensNow = fuZhuRensNow;
	}

	public List<Leaderinfo> getMasterPersPast() {
		return masterPersPast;
	}

	public void setMasterPersPast(List<Leaderinfo> masterPersPast) {
		this.masterPersPast = masterPersPast;
	}

	public List<Leaderinfo> getFuZhuRensPast() {
		return fuZhuRensPast;
	}

	public void setFuZhuRensPast(List<Leaderinfo> fuZhuRensPast) {
		this.fuZhuRensPast = fuZhuRensPast;
	}

	public List<Acainfo> getMaterAcasNow() {
		return materAcasNow;
	}

	public void setMaterAcasNow(List<Acainfo> materAcasNow) {
		this.materAcasNow = materAcasNow;
	}

	public List<Acainfo> getFuAcasNow() {
		return fuAcasNow;
	}

	public void setFuAcasNow(List<Acainfo> fuAcasNow) {
		this.fuAcasNow = fuAcasNow;
	}

	public List<Acainfo> getSingleAcasNow() {
		return singleAcasNow;
	}

	public void setSingleAcasNow(List<Acainfo> singleAcasNow) {
		this.singleAcasNow = singleAcasNow;
	}

	public List<Acainfo> getMaterAcasPast() {
		return materAcasPast;
	}

	public void setMaterAcasPast(List<Acainfo> materAcasPast) {
		this.materAcasPast = materAcasPast;
	}

	public List<Acainfo> getFuAcasPast() {
		return fuAcasPast;
	}

	public void setFuAcasPast(List<Acainfo> fuAcasPast) {
		this.fuAcasPast = fuAcasPast;
	}

	public List<Acainfo> getSingleAcasPast() {
		return singleAcasPast;
	}

	public void setSingleAcasPast(List<Acainfo> singleAcasPast) {
		this.singleAcasPast = singleAcasPast;
	}
	
	
	public List<Leaderinfo> getMiShuNow() {
		return miShuNow;
	}

	public void setMiShuNow(List<Leaderinfo> miShuNow) {
		this.miShuNow = miShuNow;
	}

	public List<Leaderinfo> getMiShuPast() {
		return miShuPast;
	}

	public void setMiShuPast(List<Leaderinfo> miShuPast) {
		this.miShuPast = miShuPast;
	}
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	public List<Leaderinfo> getLeaderinfos() {
		return leaderinfos;
	}

	public void setLeaderinfos(List<Leaderinfo> leaderinfos) {
		this.leaderinfos = leaderinfos;
	}

	public List<Acainfo> getAcainfos() {
		return acainfos;
	}

	public void setAcainfos(List<Acainfo> acainfos) {
		this.acainfos = acainfos;
	}
	
	public Resdirection getResdirection() {
		return resdirection;
	}

	public void setResdirection(Resdirection resdirection) {
		this.resdirection = resdirection;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Leaderinfo getLeaderinfo() {
		return leaderinfo;
	}

	public void setLeaderinfo(Leaderinfo leaderinfo) {
		this.leaderinfo = leaderinfo;
	}

	public Acainfo getAcainfo() {
		return acainfo;
	}

	public void setAcainfo(Acainfo acainfo) {
		this.acainfo = acainfo;
	}

	@Action(value = "/queryAcainfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_aca.jsp", 
					params = {"materAcasNow","${materAcasNow}","fuAcasNow","${fuAcasNow}","singleAcasNow","${singleAcasNow}",
							  "materAcasPast","${materAcasPast}","fuAcasPast","${fuAcasPast}","singleAcasPast","${singleAcasPast}",
							  "target","${targeet}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryAcainfos(){
		try {
			target="委员会成员";
			materAcasNow = acainfoManager.queryAcainfosByTwoType(1, 1);
			fuAcasNow = acainfoManager.queryAcainfosByTwoType(1, 2);
			singleAcasNow = acainfoManager.queryAcainfosByTwoType(1, 3);
			
			materAcasPast = acainfoManager.queryAcainfosByTwoType(0, 1);
			fuAcasPast = acainfoManager.queryAcainfosByTwoType(0, 2);
			singleAcasPast = acainfoManager.queryAcainfosByTwoType(0, 3);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	@Action(value = "/queryLeaderinfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_leader.jsp", 
					params = {"masterPersNow","${masterPersNow}","fuZhuRensNow","${fuZhuRensNow}",
							  "masterPersPast","${masterPersPast}","fuZhuRensPast","${fuZhuRensPast}",
							  "miShuNow","${miShuNow}","miShuPast","${miShuPast}",
							  "target","${target"
							  }),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryLeaderinfos(){
		try {
			target="领导成员";
			masterPersNow = leaderinfoManager.queryLeaderinfosByTwoType(1, 1);
			fuZhuRensNow = leaderinfoManager.queryLeaderinfosByTwoType(1, 2);
			miShuNow = leaderinfoManager.queryLeaderinfosByTwoType(1, 3);
			
			masterPersPast = leaderinfoManager.queryLeaderinfosByTwoType(0, 1);
			fuZhuRensPast = leaderinfoManager.queryLeaderinfosByTwoType(0, 2);
			miShuPast = leaderinfoManager.queryLeaderinfosByTwoType(0, 3);
			
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryOrganizations", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_organ.jsp", 
					params = {"organizations","${organizations}","target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryOrganizations(){
		try {
			organizations = organizationManager.findAll();
			target = "机构设置";
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryResdirections", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_resdirections.jsp", 
					params = {"resdirections","${resdirections}","target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryResdirections(){
		try {
			resdirections = resdirectionManager.findAllOrderyByTime();
			target = "研究方向";
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryLabInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/queryLab_admin.jsp", 
					params = {"resdirections","${resdirections}","organizations","${organizations}",
							  "leaderinfos","${leaderinfos}","acainfos","${acainfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryLabInfo(){
		try {
			resdirections = resdirectionManager.findAllOrderyByTime();//研究方向
			organizations = organizationManager.findAll();//机构设置
			leaderinfos = leaderinfoManager.queryLeaderinfos();//领导人员信息
			acainfos = acainfoManager.findAll();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addResdirection", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addLab_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addResdirection(){
		try {
			resdirection.setTime(new Date(System.currentTimeMillis()));
			resdirectionManager.save(resdirection);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addOrganization", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addLab_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addOrganization(){
		try {
			organization.setTime(new Date(System.currentTimeMillis()));
			organizationManager.save(organization);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addAcaInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addLab_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addAcaInfo(){
		try {
			acainfoManager.save(acainfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
