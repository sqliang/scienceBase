package com.science.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Evaluationinfo;
import com.science.domain.Magsysinfo;
import com.science.serviceManager.EvaluationinfoManager;
import com.science.serviceManager.JManager;
import com.science.serviceManager.MagsysinfoManager;
import com.science.serviceManager.SubmenuManager;
import com.science.util.DelFileUtil;
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
	//file不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;
	//提交过来的文件名字
	private String fileName;
	//提交过来的file的MIME类型
	private String fileContentType;
	
	private  Evaluationinfo evaluationinfo;
	private String evaluationId;
	private String downloadUrl;
	
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
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
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
			String[] tempArr = fileName.split("\\.");
			String evaluationTitle = tempArr[0];
			
			evaluationinfo = new Evaluationinfo();
			System.out.println(new Date(System.currentTimeMillis()));
			evaluationinfo.setTime(new Date(System.currentTimeMillis()));
			evaluationinfo.setEvaluationtitle(evaluationTitle);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String dateTime = sdf.format(new Date(System.currentTimeMillis()));
			fileName = dateTime + "."+tempArr[1];
			String filePath = "/upload/" + fileName;
			evaluationinfo.setUploadcontenturl(filePath);
			
			String root = ServletActionContext.getServletContext().getRealPath("/upload");
			File temp = new File(root);
			if(!temp.exists()){
				temp.mkdirs();
			}
			InputStream is = new FileInputStream(file);
			OutputStream os = new FileOutputStream(new File(root,fileName));
			byte[] buffer = new byte[500];
			int len = 0;
			while(-1 != (len = is.read(buffer, 0, buffer.length))){
				os.write(buffer);
			}
			os.close();
			is.close();
			
			evaluationinfoManager.save(evaluationinfo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
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
			evaluationinfo = evaluationinfoManager.queryEvaluationById(Integer.parseInt(evaluationId));
			String filePath = evaluationinfo.getUploadcontenturl();
			String  path = ServletActionContext.getServletContext().getRealPath(filePath);
			DelFileUtil.deleteFile(path);
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
