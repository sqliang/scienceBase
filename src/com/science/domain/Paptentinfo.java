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
@Table(name="paptentinfo")
public class Paptentinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long paptentid;
	private String paptentname;
	private String paptenttype;
	private String paptentauthors;
	private Date agreetime;
	private String paptentstatus;
	private String paptentintr;
	public static  final Paptentinfo NULL =new PaptentinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Paptentinfo load(Serializable id){
		PaptentinfoManager paptentinfoManager = (PaptentinfoManager)BeanUtil.load("paptentinfoManagerImpl");
		Paptentinfo paptentinfo=paptentinfoManager.get(id);
		return paptentinfo;

	}
	public  void setPaptentid(long paptentid){
		this.paptentid=paptentid;

	}
	@Id
	@Column(name="paptentId",length=22,nullable = false)
	public  long getPaptentid(){
		return this.paptentid;

	}
	public  void setPaptentname(String paptentname){
		this.paptentname=paptentname;

	}
	@Column(name="paptentName",length=400)
	public  String getPaptentname(){
		return this.paptentname;

	}
	public  void setPaptenttype(String paptenttype){
		this.paptenttype=paptenttype;

	}
	@Column(name="paptentType",length=40)
	public  String getPaptenttype(){
		return this.paptenttype;

	}
	public  void setPaptentauthors(String paptentauthors){
		this.paptentauthors=paptentauthors;

	}
	@Column(name="paptentAuthors",length=200)
	public  String getPaptentauthors(){
		return this.paptentauthors;

	}
	public  void setAgreetime(Date agreetime){
		this.agreetime=agreetime;

	}
	@Column(name="agreeTime",length=7)
	public  Date getAgreetime(){
		return this.agreetime;

	}
	public  void setPaptentstatus(String paptentstatus){
		this.paptentstatus=paptentstatus;

	}
	@Column(name="paptentStatus",length=40)
	public  String getPaptentstatus(){
		return this.paptentstatus;

	}
	@Column(name="paptentIntr",length=4000)
	public String getPaptentintr() {
		return paptentintr;
	}
	public void setPaptentintr(String paptentintr) {
		this.paptentintr = paptentintr;
	}
	
}
