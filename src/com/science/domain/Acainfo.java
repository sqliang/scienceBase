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
@Table(name="acainfo")
public class Acainfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long acaid;
	private String acaname;
	private long acasex;
	private long acaage;
	private long position;
	private long acatype;
	private Date officedate;
	private String intrurl;
	public static  final Acainfo NULL =new AcainfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Acainfo load(Serializable id){
		AcainfoManager acainfoManager = (AcainfoManager)BeanUtil.load("acainfoManagerImpl");
		Acainfo acainfo=acainfoManager.get(id);
		return acainfo;

	}
	public  void setAcaid(long acaid){
		this.acaid=acaid;

	}
	@Id
	@Column(name="acaId",length=22,nullable = false)
	public  long getAcaid(){
		return this.acaid;

	}
	public  void setAcaname(String acaname){
		this.acaname=acaname;

	}
	@Column(name="acaName",length=40)
	public  String getAcaname(){
		return this.acaname;

	}
	public  void setAcasex(long acasex){
		this.acasex=acasex;

	}
	@Column(name="acaSex",length=22)
	public  long getAcasex(){
		return this.acasex;

	}
	public  void setAcaage(long acaage){
		this.acaage=acaage;

	}
	@Column(name="acaAge",length=22)
	public  long getAcaage(){
		return this.acaage;

	}
	public  void setPosition(long position){
		this.position=position;

	}
	@Column(name="position",length=22)
	public  long getPosition(){
		return this.position;

	}
	public  void setAcatype(long acatype){
		this.acatype=acatype;

	}
	@Column(name="acaType",length=22)
	public  long getAcatype(){
		return this.acatype;

	}
	public  void setOfficedate(Date officedate){
		this.officedate=officedate;

	}
	@Column(name="officeDate",length=7)
	public  Date getOfficedate(){
		return this.officedate;

	}
	public  void setIntrurl(String intrurl){
		this.intrurl=intrurl;

	}
	@Column(name="intrUrl",length=4000)
	public  String getIntrurl(){
		return this.intrurl;

	}
}
