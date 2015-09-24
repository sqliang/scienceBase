package com.science.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Resourceinfo;
import com.science.domain.Scienceedu;
import com.science.serviceManager.ResourceinfoManager;
import com.science.serviceManager.ScienceeduManager;
import com.science.serviceManager.SubmenuManager;
import com.science.util.string.StringUtil;

public class ResourceManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ResourceinfoManager resourceinfoManager;
	@Autowired
	private ScienceeduManager scienceeduManager;
	@Autowired
	private SubmenuManager submenuManager;
	
	private List<Resourceinfo> resourceinfos;
	private List<Scienceedu> scienceedus;
	private long resourceType;
	private String subMenuName;
	private long mainMenuId;
	
	private Resourceinfo resourceinfo;
	private Scienceedu scienceedu;
	
	public List<Resourceinfo> getResourceinfos() {
		return resourceinfos;
	}
	public void setResourceinfos(List<Resourceinfo> resourceinfos) {
		this.resourceinfos = resourceinfos;
	}
	public List<Scienceedu> getScienceedus() {
		return scienceedus;
	}
	public void setScienceedus(List<Scienceedu> scienceedus) {
		this.scienceedus = scienceedus;
	}
	public long getResourceType() {
		return resourceType;
	}
	public void setResourceType(long resourceType) {
		this.resourceType = resourceType;
	}
	public Resourceinfo getResourceinfo() {
		return resourceinfo;
	}
	public void setResourceinfo(Resourceinfo resourceinfo) {
		this.resourceinfo = resourceinfo;
	}
	public Scienceedu getScienceedu() {
		return scienceedu;
	}
	public void setScienceedu(Scienceedu scienceedu) {
		this.scienceedu = scienceedu;
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
	@Action(value = "/queryResourceByType", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_resource.jsp", 
					params = {"resourceinfos","${resourceinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryResourceByType(){
		try {
			resourceinfos = resourceinfoManager.queryResourceByType(resourceType);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryScienceEdu", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_scienceedu.jsp", 
					params = {"scienceedus","${scienceedus}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryScienceEdu(){
		try {
			scienceedus = scienceeduManager.queryScienceeduByTime();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryResource", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/queryResource_admin.jsp", 
					params = {"resourceinfos","${resourceinfos}","scienceedus","${scienceedus}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryResource(){
		try {
			resourceinfos = resourceinfoManager.queryResourceByTime();
			scienceedus = scienceeduManager.queryScienceeduByTime();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addResourceinfo",
			results = {
				@Result(name = "success", type = "dispatcher", location = "/admin/addResource_admin.jsp",
						params = {}),
				@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
						params = {"msg","${msg}"})})
	public String addResourceinfo(){
		try {
			resourceinfo.setTime(new Date(System.currentTimeMillis()));
			resourceinfoManager.save(resourceinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addScienceedu",
			results = {
				@Result(name = "success", type = "dispatcher", location = "/admin/addResource_admin.jsp",
						params = {}),
				@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
						params = {"msg","${msg}"})})
	public String addScienceedu(){
		try {
			scienceedu.setTime(new Date(System.currentTimeMillis()));
			scienceeduManager.save(scienceedu);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}