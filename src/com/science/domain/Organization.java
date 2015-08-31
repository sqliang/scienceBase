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
@Table(name="organization")
public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;

	private long orgid;
	private String orgtitle;
	private Date time;
	private String content;
	public static  final Organization NULL =new OrganizationNULL();

	public  void reloadForegnKey(){

	}
	public static  Organization load(Serializable id){
		OrganizationManager organizationManager = (OrganizationManager)BeanUtil.load("organizationManagerImpl");
		Organization organization=organizationManager.get(id);
		return organization;

	}
	public  void setOrgid(long orgid){
		this.orgid=orgid;

	}
	@Id
	@Column(name="orgId",length=22,nullable = false)
	public  long getOrgid(){
		return this.orgid;

	}
	public  void setOrgtitle(String orgtitle){
		this.orgtitle=orgtitle;

	}
	@Column(name="orgTitle",length=200)
	public  String getOrgtitle(){
		return this.orgtitle;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
	public  void setContent(String content){
		this.content=content;

	}
	@Column(name="content",length=4000)
	public  String getContent(){
		return this.content;

	}
}
