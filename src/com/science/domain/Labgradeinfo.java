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
@Table(name="labgradeinfo")
public class Labgradeinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long labgradeid;
	private String gradename;
	private String gradedengji;
	private String gradetype;
	private String gradefinish;
	private Date time;
	private String gradeintr;
	public static  final Labgradeinfo NULL =new LabgradeinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Labgradeinfo load(Serializable id){
		LabgradeinfoManager labgradeinfoManager = (LabgradeinfoManager)BeanUtil.load("labgradeinfoManagerImpl");
		Labgradeinfo labgradeinfo=labgradeinfoManager.get(id);
		return labgradeinfo;

	}
	public  void setLabgradeid(long labgradeid){
		this.labgradeid=labgradeid;

	}
	@Id
	@Column(name="labGradeId",length=22,nullable = false)
	public  long getLabgradeid(){
		return this.labgradeid;

	}
	public  void setGradename(String gradename){
		this.gradename=gradename;

	}
	@Column(name="gradeName",length=200)
	public  String getGradename(){
		return this.gradename;

	}
	public  void setGradedengji(String gradedengji){
		this.gradedengji=gradedengji;

	}
	@Column(name="gradeDengJi",length=100)
	public  String getGradedengji(){
		return this.gradedengji;

	}
	public  void setGradetype(String gradetype){
		this.gradetype=gradetype;

	}
	@Column(name="gradeType",length=100)
	public  String getGradetype(){
		return this.gradetype;

	}
	public  void setGradefinish(String gradefinish){
		this.gradefinish=gradefinish;

	}
	@Column(name="gradeFinish",length=40)
	public  String getGradefinish(){
		return this.gradefinish;

	}
	
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
	@Column(name="gradeIntr",length=4000)
	public String getGradeintr() {
		return gradeintr;
	}
	public void setGradeintr(String gradeintr) {
		this.gradeintr = gradeintr;
	}
	
}
