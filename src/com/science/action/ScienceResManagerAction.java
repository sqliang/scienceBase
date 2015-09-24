package com.science.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Bookinfo;
import com.science.domain.Labgradeinfo;
import com.science.domain.Paperinfo;
import com.science.domain.Paptentinfo;
import com.science.domain.Presentachiveinfo;
import com.science.domain.Projectinfo;
import com.science.serviceManager.BookinfoManager;
import com.science.serviceManager.JManager;
import com.science.serviceManager.LabgradeinfoManager;
import com.science.serviceManager.PaperinfoManager;
import com.science.serviceManager.PaptentinfoManager;
import com.science.serviceManager.PresentachiveinfoManager;
import com.science.serviceManager.ProjectinfoManager;
import com.science.serviceManager.SubmenuManager;
import com.science.util.string.StringUtil;

public class ScienceResManagerAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProjectinfoManager projectinfoManager;
	@Autowired
	private PaperinfoManager paperinfoManager;
	@Autowired
	private BookinfoManager bookinfoManager;
	@Autowired
	private PaptentinfoManager paptentinfoManager;
	@Autowired
	private LabgradeinfoManager labgradeinfoManager;
	@Autowired
	private PresentachiveinfoManager presentachiveinfoManager;
	@Autowired
	private SubmenuManager submenuManager;
	@Autowired
	private JManager jManager;
	
	private List<Projectinfo> projectinfos;
	private List<Paperinfo> paperinfos;
	private List<Bookinfo> bookinfos;
	private List<Paptentinfo> paptentinfos;
	private List<Labgradeinfo> labgradeinfos;
	private List<Presentachiveinfo> presentachiveinfos;
	private String subMenuName;
	private long mainMenuId;
	private Projectinfo projectinfo;
	private Paperinfo paperinfo;
	private Bookinfo bookinfo;
	private Paptentinfo paptentinfo;
	private Labgradeinfo labgradeinfo;
	private Presentachiveinfo presentachiveinfo;
	private String pageNow;
	private long limit;
	private long start;
	private long totalPages;
	
	
	public List<Projectinfo> getProjectinfos() {
		return projectinfos;
	}

	public void setProjectinfos(List<Projectinfo> projectinfos) {
		this.projectinfos = projectinfos;
	}

	public List<Paperinfo> getPaperinfos() {
		return paperinfos;
	}

	public void setPaperinfos(List<Paperinfo> paperinfos) {
		this.paperinfos = paperinfos;
	}

	public List<Bookinfo> getBookinfos() {
		return bookinfos;
	}

	public void setBookinfos(List<Bookinfo> bookinfos) {
		this.bookinfos = bookinfos;
	}

	public List<Paptentinfo> getPaptentinfos() {
		return paptentinfos;
	}

	public void setPaptentinfos(List<Paptentinfo> paptentinfos) {
		this.paptentinfos = paptentinfos;
	}

	public List<Labgradeinfo> getLabgradeinfos() {
		return labgradeinfos;
	}

	public void setLabgradeinfos(List<Labgradeinfo> labgradeinfos) {
		this.labgradeinfos = labgradeinfos;
	}

	public List<Presentachiveinfo> getPresentachiveinfos() {
		return presentachiveinfos;
	}

	public void setPresentachiveinfos(List<Presentachiveinfo> presentachiveinfos) {
		this.presentachiveinfos = presentachiveinfos;
	}
	
	public Projectinfo getProjectinfo() {
		return projectinfo;
	}

	public void setProjectinfo(Projectinfo projectinfo) {
		this.projectinfo = projectinfo;
	}

	public Paperinfo getPaperinfo() {
		return paperinfo;
	}

	public void setPaperinfo(Paperinfo paperinfo) {
		this.paperinfo = paperinfo;
	}

	public Bookinfo getBookinfo() {
		return bookinfo;
	}

	public void setBookinfo(Bookinfo bookinfo) {
		this.bookinfo = bookinfo;
	}

	public Paptentinfo getPaptentinfo() {
		return paptentinfo;
	}

	public void setPaptentinfo(Paptentinfo paptentinfo) {
		this.paptentinfo = paptentinfo;
	}

	public Labgradeinfo getLabgradeinfo() {
		return labgradeinfo;
	}

	public void setLabgradeinfo(Labgradeinfo labgradeinfo) {
		this.labgradeinfo = labgradeinfo;
	}

	public Presentachiveinfo getPresentachiveinfo() {
		return presentachiveinfo;
	}

	public void setPresentachiveinfo(Presentachiveinfo presentachiveinfo) {
		this.presentachiveinfo = presentachiveinfo;
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

	@Action(value = "/queryProjectinfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_project.jsp", 
					params = {"projectinfos","${projectinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}","totalPages","${totalPages}",
							  "pageNow","${pageNow}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryProjectinfos(){
		try {
			long totalCount = Long.parseLong(jManager.simpleSQL("select count(*) from projectinfo"));
			limit = 10;
			start = (Integer.parseInt(pageNow) - 1)*limit;
			totalPages = (totalCount + limit -1)/limit;
			projectinfos = projectinfoManager.queryProjectByFenye(start, limit);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryPaperinfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_paper.jsp", 
					params = {"paperinfos","${paperinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}","totalPages","${totalPages}",
							  "pageNow","${pageNow}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryPaperinfos(){
		try {
			long totalCount = Long.parseLong(jManager.simpleSQL("select count(*) from paperinfo"));
			limit = 10;
			start = (Integer.parseInt(pageNow) - 1)*limit;
			totalPages = (totalCount + limit -1)/limit;
			paperinfos = paperinfoManager.queryPaperByFenye(start, limit);
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryBookinfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_book.jsp", 
					params = {"bookinfos","${bookinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryBookinfos(){
		try {
			bookinfos = bookinfoManager.queryBookOrderByTime();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryPaptentinfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_paptent.jsp", 
					params = {"paptentinfos","${paptentinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryPaptentinfos(){
		try {
			paptentinfos = paptentinfoManager.queryPaptentOrderByTime();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryLabgradeinfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_labgrade.jsp", 
					params = {"labgradeinfos","${labgradeinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryLabgradeinfos(){
		try {
			labgradeinfos = labgradeinfoManager.queryLabGradeOrderByTime();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/queryPresentachiveinfos", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_presentachive.jsp", 
					params = {"presentachiveinfos","${presentachiveinfos}","subMenuName","${subMenuName}",
							  "mainMenuId","${mainMenuId}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryPresentachiveinfos(){
		try {
			presentachiveinfos = presentachiveinfoManager.queryPresentachibeOrderByTime();
			subMenuName = StringUtil.convertCodeToUtf(subMenuName);
			mainMenuId = submenuManager.querySubByName(subMenuName).getMainmenuid();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "/adminQueryScienceRes", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/queryScienceRes_admin.jsp", 
					params = {"projectinfos","${projectinfos}","paperinfos","${paperinfos}",
							  "bookinfos","${bookinfos}","paptentinfos","${paptentinfos}",
							  "labgradeinfos","${labgradeinfos}","presentachiveinfos","${presentachiveinfos}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String adminQueryScienceRes(){
		try {
			projectinfos = projectinfoManager.queryProjectOrderBytime();
			paperinfos = paperinfoManager.queryPaperOrderByTime();
			bookinfos = bookinfoManager.queryBookOrderByTime();
			paptentinfos = paptentinfoManager.queryPaptentOrderByTime();
			labgradeinfos = labgradeinfoManager.queryLabGradeOrderByTime();
			presentachiveinfos = presentachiveinfoManager.queryPresentachibeOrderByTime();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addProjectInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addScienceRes_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addProjectInfo(){
		try {
			projectinfo.setTime(new Date(System.currentTimeMillis()));
			projectinfoManager.save(projectinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addPaperInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addScienceRes_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addPaperInfo(){
		try {
			paperinfo.setTime(new Date(System.currentTimeMillis()));
			paperinfoManager.save(paperinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addBookInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addScienceRes_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addBookInfo(){
		try {
			bookinfo.setTime(new Date(System.currentTimeMillis()));
			bookinfoManager.save(bookinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addPaptentInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addScienceRes_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addPaptentInfo(){
		try {
			paptentinfoManager.save(paptentinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addLabGradeInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addScienceRes_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addLabGradeInfo(){
		try {
			labgradeinfo.setTime(new Date(System.currentTimeMillis()));
			labgradeinfoManager.save(labgradeinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addPresentGradeInfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addScienceRes_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addPresentGradeInfo(){
		try {
			presentachiveinfo.setTime(new Date(System.currentTimeMillis()));
			presentachiveinfoManager.save(presentachiveinfo);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
