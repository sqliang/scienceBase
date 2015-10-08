package com.science.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.ModelClause.MainModelClause;
import com.science.domain.Acainfo;
import com.science.domain.Leaderinfo;
import com.science.domain.Memberinfo;
import com.science.domain.Organization;
import com.science.domain.Resdirection;
import com.science.domain.Submenu;
import com.science.serviceManager.AcainfoManager;
import com.science.serviceManager.LeaderinfoManager;
import com.science.serviceManager.OrganizationManager;
import com.science.serviceManager.ResdirectionManager;
import com.science.serviceManager.SubmenuManager;
import com.science.util.string.StringUtil;

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
	@Autowired
	private SubmenuManager submenuManager;
	
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
	private String subMenuName;
	private long mainMenuId;
	private List<Leaderinfo> leaderinfos;
	private List<Acainfo> acainfos;
	
	private Resdirection resdirection;
	private Organization organization;
	private Leaderinfo leaderinfo;
	private Acainfo acainfo;
	private String orgId;
	private String dirId;
	private String leaderId;
	private String acaId;
	

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
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDirId() {
		return dirId;
	}

	public void setDirId(String dirId) {
		this.dirId = dirId;
	}
	
	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	
	public String getAcaId() {
		return acaId;
	}

	public void setAcaId(String acaId) {
		this.acaId = acaId;
	}

	@Action(value = "/queryAcainfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_aca.jsp", 
					params = {"materAcasNow","${materAcasNow}","fuAcasNow","${fuAcasNow}","singleAcasNow","${singleAcasNow}",
							  "materAcasPast","${materAcasPast}","fuAcasPast","${fuAcasPast}","singleAcasPast","${singleAcasPast}",
							  "subMenuName","${subMenuName}","mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryAcainfos(){
		try {
			materAcasNow = acainfoManager.queryAcainfosByTwoType(1, 1);
			fuAcasNow = acainfoManager.queryAcainfosByTwoType(1, 2);
			singleAcasNow = acainfoManager.queryAcainfosByTwoType(1, 3);
			
			materAcasPast = acainfoManager.queryAcainfosByTwoType(0, 1);
			fuAcasPast = acainfoManager.queryAcainfosByTwoType(0, 2);
			singleAcasPast = acainfoManager.queryAcainfosByTwoType(0, 3);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
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
							  "subMenuName","${subMenuName}","mainMenuId","${mainMenuId}"
							  }),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryLeaderinfos(){
		try {
			//subMenuName="领导成员";
			masterPersNow = leaderinfoManager.queryLeaderinfosByTwoType(1, 1);
			fuZhuRensNow = leaderinfoManager.queryLeaderinfosByTwoType(1, 2);
			miShuNow = leaderinfoManager.queryLeaderinfosByTwoType(1, 3);
			
			masterPersPast = leaderinfoManager.queryLeaderinfosByTwoType(0, 1);
			fuZhuRensPast = leaderinfoManager.queryLeaderinfosByTwoType(0, 2);
			miShuPast = leaderinfoManager.queryLeaderinfosByTwoType(0, 3);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryOrganizations", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_organ.jsp", 
					params = {"organizations","${organizations}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryOrganizations(){
		try {
			organizations = organizationManager.findAll();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "queryOrgnaizationById", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/detail_org.jsp", 
					params = {"organization","${organization}","subMenuName","${subMenuName}",
					  		  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryOrgnaizationById(){
		try {
			organization = organizationManager.queryOrgById(Integer.parseInt(orgId));
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	
	@Action(value = "/queryResdirections", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_resdirections.jsp", 
					params = {"resdirections","${resdirections}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryResdirections(){
		try {
			resdirections = resdirectionManager.findAllOrderyByTime();
			//subMenuName = "研究方向";
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "queryResdiretById", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/detail_resdir.jsp", 
					params = {"resdirection","${resdirection}","subMenuName","${subMenuName}",
					  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryResdiretById(){
		try {
			resdirection = resdirectionManager.queryResdirById(Integer.parseInt(dirId));
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
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
	
	@Action(value = "/delResdirectionById", 
			results = { 
			@Result(name = "success", type = "redirect", location = "/adminQueryLabInfo"),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String delResdirectionById(){
		try {
			resdirectionManager.delResdirById(Long.parseLong(dirId));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/delOrgById", 
			results = { 
			@Result(name = "success", type = "redirect", location = "/adminQueryLabInfo"),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String delOrgById(){
		try {
			organizationManager.deletebyProperty("orgId", orgId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/delLeaderInfoById", 
			results = { 
			@Result(name = "success", type = "redirect", location = "/adminQueryLabInfo"),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String delLeaderInfoById(){
		try {
			leaderinfoManager.deletebyProperty("leaderId", leaderId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/delAcaInfoById", 
			results = { 
			@Result(name = "success", type = "redirect", location = "/adminQueryLabInfo"),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String delAcaInfoById(){
		try {
			acainfoManager.deletebyProperty("acaId", acaId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
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
