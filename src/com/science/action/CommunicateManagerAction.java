package com.science.action;

import java.util.Date;
import java.util.List;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Communicateinfo;
import com.science.domain.Pubclassinfo;
import com.science.serviceManager.CommunicateinfoManager;
import com.science.serviceManager.JManager;
import com.science.serviceManager.PubclassinfoManager;
import com.science.serviceManager.SubmenuManager;
import com.science.util.string.StringUtil;

public class CommunicateManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CommunicateinfoManager communicateinfoManager;
	@Autowired
	private PubclassinfoManager pubclassinfoManager;
	@Autowired
	private SubmenuManager submenuManager;
	@Autowired
	private JManager jManager;
	
	private List<Communicateinfo> communicateinfos;
	private List<Pubclassinfo> pubclassinfos;
	private String communicateType;
	private String subMenuName;
	private Communicateinfo communicateinfo;
	private Pubclassinfo pubclassinfo;
	private long mainMenuId;
	
	private String pageNow;
	private long limit;
	private long start;
	private long totalPages;
	private String communicateId;
	private String pubClassId;
	
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
	
	public String getCommunicateType() {
		return communicateType;
	}
	public void setCommunicateType(String communicateType) {
		this.communicateType = communicateType;
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
	public String getCommunicateId() {
		return communicateId;
	}
	public void setCommunicateId(String communicateId) {
		this.communicateId = communicateId;
	}
	public String getPubClassId() {
		return pubClassId;
	}
	public void setPubClassId(String pubClassId) {
		this.pubClassId = pubClassId;
	}
	@Action(value = "/queryCommuicateByType", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_communicate.jsp", 
					params = {"communicateinfos","${communicateinfos}","communicateType","${communicateType}",
							  "totalPages","${totalPages}","pageNow","${pageNow}",
							  "subMenuName","${subMenuName}","mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryCommuicateByType(){
		try {
			long totalCount = Long.parseLong(jManager.simpleSQL("select count(*) from communicateinfo where communicateType=?",Integer.parseInt(communicateType)));
			limit = 12;
			start = (Integer.parseInt(pageNow) - 1)*limit;
			totalPages = (totalCount + limit -1)/limit;
			communicateinfos = communicateinfoManager.queryCommuicateByType(Integer.parseInt(communicateType),start,limit);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Action(value = "/queryPubclassBytime", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_pubclass.jsp", 
					params = {"pubclassinfos","${pubclassinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryPubclassBytime(){
		try {
			pubclassinfos = pubclassinfoManager.queryPubclassBytime();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
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
	
	@Action(value = "delCommunicateinfoById",
			results = {
				@Result(name = "success", type = "redirect", location = "/adminQueryComunicate"),
						@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
						params = {"msg","${msg}"})})
	public String delCommunicateinfoById(){
		try {
			communicateinfoManager.deletebyProperty("communicateId", communicateId);
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
	
	@Action(value = "delPubclassinfoById",
			results = {
				@Result(name = "success", type = "redirect", location = "/adminQueryComunicate"),
						@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
						params = {"msg","${msg}"})})
	public String delPubclassinfoById(){
		try {
			pubclassinfoManager.deletebyProperty("pubClassId", pubClassId);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}


	
}
