package com.science.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.domain.Newsinfo;
import com.science.domain.Picnews;
import com.science.serviceManager.JManager;
import com.science.serviceManager.NewsinfoManager;
import com.science.serviceManager.PicnewsManager;


public class HomPageNewsAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private JManager jManager;
	@Autowired
	private NewsinfoManager newsinfoManager;
	@Autowired
	private PicnewsManager picnewsManager;
	private List<Newsinfo> lastNewss;
	private List<Newsinfo> noticeNewss;//通知公告
	private List<Newsinfo> resReports;//学术报告
	private List<Newsinfo> resDongTais;//学术动态
	private List<Picnews> picnewss;
	private Newsinfo newsinfo;
	private Picnews picnews;
	private String newsId;
	private List<Newsinfo> newsinfos;
	private String newsType;
	private String target;
	

	public List<Newsinfo> getLastNewss() {
		return lastNewss;
	}



	public void setLastNewss(List<Newsinfo> lastNewss) {
		this.lastNewss = lastNewss;
	}



	public List<Newsinfo> getNoticeNewss() {
		return noticeNewss;
	}



	public void setNoticeNewss(List<Newsinfo> noticeNewss) {
		this.noticeNewss = noticeNewss;
	}



	public List<Newsinfo> getResReports() {
		return resReports;
	}



	public void setResReports(List<Newsinfo> resReports) {
		this.resReports = resReports;
	}



	public List<Newsinfo> getResDongTais() {
		return resDongTais;
	}



	public void setResDongTais(List<Newsinfo> resDongTais) {
		this.resDongTais = resDongTais;
	}



	public List<Picnews> getPicnewss() {
		return picnewss;
	}



	public void setPicnewss(List<Picnews> picnewss) {
		this.picnewss = picnewss;
	}


	public Newsinfo getNewsinfo() {
		return newsinfo;
	}



	public void setNewsinfo(Newsinfo newsinfo) {
		this.newsinfo = newsinfo;
	}
	
	public Picnews getPicnews() {
		return picnews;
	}



	public void setPicnews(Picnews picnews) {
		this.picnews = picnews;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}
	
	public List<Newsinfo> getNewsinfos() {
		return newsinfos;
	}



	public void setNewsinfos(List<Newsinfo> newsinfos) {
		this.newsinfos = newsinfos;
	}



	public String getNewsType() {
		return newsType;
	}



	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Action(value = "homePage", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/index.jsp", 
					params = {"picnewss","${picnewss}","lastNewss","${lastNewss}",
							  "noticeNewss","${noticeNewss}","resReports","${resReports}",
							  "resDongTais","${resDongTais}" }),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String homePage(){
		try {
			picnewss = picnewsManager.queryPicNews();
			lastNewss = newsinfoManager.queryNewsinfoByType(1);
			noticeNewss = newsinfoManager.queryNewsinfoByType(2);
			resReports = newsinfoManager.queryNewsinfoByType(3);
			resDongTais =  newsinfoManager.queryNewsinfoByType(4);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "queryNewsByType", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/list_news.jsp", 
					params = {"newsinfos","${newsinfos}","target","${target}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryNewsByType(){
		try {
			newsinfos = newsinfoManager.queryNewsinfoByType(Integer.parseInt(newsType));
			Newsinfo newsinfo = newsinfos.get(0);
			if(newsinfo.getNewstype() == 1){
				target = "最近新闻";
			}else if(newsinfo.getNewstype() == 2){
				target = "通知公告";
			}else if(newsinfo.getNewstype() == 3){
				target = "学术报告";
			}else {
				target = "学术动态";
			}
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "queryNewsById", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/jsp/detail_news.jsp", 
					params = {"newsinfo","${newsinfo}"}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String queryNewsById(){
		try {
			newsinfo = newsinfoManager.queryNewsinfoById(Integer.parseInt(newsId));
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "homeAdmin", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/index_admin.jsp", 
					params = {"picnewss","${picnewss}","lastNewss","${lastNewss}",
							  "noticeNewss","${noticeNewss}","resReports","${resReports}",
							  "resDongTais","${resDongTais}" }),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String homeAdmin(){
		try {
			picnewss = picnewsManager.queryPicNews();
			lastNewss = newsinfoManager.queryNewsinfoByType(1);
			noticeNewss = newsinfoManager.queryNewsinfoByType(2);
			resReports = newsinfoManager.queryNewsinfoByType(3);
			resDongTais =  newsinfoManager.queryNewsinfoByType(4);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	@Action(value = "addNewsinfo", 
			results = { 
			@Result(name = "success", type = "dispatcher", location = "/admin/addNews_admin.jsp", 
					params = {}),
			@Result(name="error",type="dispatcher",location = "/jsp/error.jsp",
					params = {"msg","${msg}"})})
	public String addNewsinfo(){
		try {
			newsinfo.setTime(new Date(System.currentTimeMillis()));
			if(newsinfo.getStatus() == 1){
				long newsId = jManager.saveAndGetId(newsinfo);
				picnews = new Picnews();
				picnews.setNewsid(newsId);
				picnews.setImgurl(newsinfo.getPictureurl1());
				picnewsManager.save(picnews);
			}else{
				newsinfoManager.save(newsinfo);
			}
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
}
