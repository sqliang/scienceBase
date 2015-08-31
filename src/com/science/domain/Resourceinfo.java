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
import com.science.serviceManager.JManager;
import com.science.serviceManager.*;
import java.util.List;
import javax.persistence.Transient;
import java.util.ArrayList;
import com.science.util.bean.BeanUtil;

@Entity
@Table(name="resourceinfo")
public class Resourceinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long resourceid;
	private String resourcetitle;
	private long resourcetype;
	private String sharemethod;
	private String useintroduce;
	private String usedinfo;
	private Date time;
	public static  final Resourceinfo NULL =new ResourceinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Resourceinfo load(Serializable id){
		ResourceinfoManager resourceinfoManager = (ResourceinfoManager)BeanUtil.load("resourceinfoManagerImpl");
		Resourceinfo resourceinfo=resourceinfoManager.get(id);
		return resourceinfo;

	}
	public  void setResourceid(long resourceid){
		this.resourceid=resourceid;

	}
	@Id
	@Column(name="resourceId",length=22,nullable = false)
	public  long getResourceid(){
		return this.resourceid;

	}
	public  void setResourcetype(long resourcetype){
		this.resourcetype=resourcetype;

	}
	@Column(name="resourceType",length=22)
	public  long getResourcetype(){
		return this.resourcetype;

	}
	public  void setSharemethod(String sharemethod){
		this.sharemethod=sharemethod;

	}
	@Column(name="shareMethod",length=100)
	public  String getSharemethod(){
		return this.sharemethod;

	}
	public  void setUseintroduce(String useintroduce){
		this.useintroduce=useintroduce;

	}
	@Column(name="useIntroduce",length=4000)
	public  String getUseintroduce(){
		return this.useintroduce;

	}
	public  void setUsedinfo(String usedinfo){
		this.usedinfo=usedinfo;

	}
	@Column(name="usedInfo",length=4000)
	public  String getUsedinfo(){
		return this.usedinfo;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
	@Column(name="resourceTitle",length=400)
	public String getResourcetitle() {
		return resourcetitle;
	}
	public void setResourcetitle(String resourcetitle) {
		this.resourcetitle = resourcetitle;
	}
	
}
