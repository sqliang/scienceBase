package com.science.domain;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.GeneratedValue;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Lob;

import com.science.util.json.JsonUtil;
import com.science.serviceManager.*;

import java.util.List;

import javax.persistence.Transient;

import java.util.ArrayList;

import com.science.util.bean.BeanUtil;

@Entity
@Table(name="projectinfo")
public class Projectinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long projid;
	private String projcode;
	private String projname;
	private String projtype;
	private String projagreeorg;
	private String projmasterperson;
	private Date projstarttime;
	private Date projendtime;
	private String projfee;
	private String projcontent;
	private Date time;
	public static  final Projectinfo NULL =new ProjectinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Projectinfo load(Serializable id){
		ProjectinfoManager projectinfoManager = (ProjectinfoManager)BeanUtil.load("projectinfoManagerImpl");
		Projectinfo projectinfo=projectinfoManager.get(id);
		return projectinfo;

	}
	public  void setProjid(long projid){
		this.projid=projid;

	}
	@Id
	@Column(name="projId",length=22,nullable = false)
	public  long getProjid(){
		return this.projid;

	}
	public  void setProjcode(String projcode){
		this.projcode=projcode;

	}
	@Column(name="projCode",length=400)
	public  String getProjcode(){
		return this.projcode;

	}
	public  void setProjname(String projname){
		this.projname=projname;

	}
	@Column(name="projName",length=200)
	public  String getProjname(){
		return this.projname;

	}
	public  void setProjtype(String projtype){
		this.projtype=projtype;

	}
	@Column(name="projType",length=200)
	public  String getProjtype(){
		return this.projtype;

	}
	public  void setProjagreeorg(String projagreeorg){
		this.projagreeorg=projagreeorg;

	}
	@Column(name="projAgreeOrg",length=200)
	public  String getProjagreeorg(){
		return this.projagreeorg;

	}
	public  void setProjmasterperson(String projmasterperson){
		this.projmasterperson=projmasterperson;

	}
	@Column(name="projMasterPerson",length=40)
	public  String getProjmasterperson(){
		return this.projmasterperson;

	}
	public  void setProjstarttime(Date projstarttime){
		this.projstarttime=projstarttime;

	}
	@Column(name="projStartTime",length=7)
	public  Date getProjstarttime(){
		return this.projstarttime;

	}
	public  void setProjendtime(Date projendtime){
		this.projendtime=projendtime;

	}
	@Column(name="projEndTime",length=7)
	public  Date getProjendtime(){
		return this.projendtime;

	}
	public  void setProjfee(String projfee){
		this.projfee=projfee;

	}
	@Column(name="projFee",length=40)
	public  String getProjfee(){
		return this.projfee;

	}
	
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
	public void setProjcontent(String projcontent) {
		this.projcontent = projcontent;
	}
	@Column(name="projContent",length=4000)
	public String getProjcontent() {
		return projcontent;
	}
}
