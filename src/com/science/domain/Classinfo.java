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
@Table(name="classinfo")
public class Classinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long classid;
	private String classname;
	private String classteacher;
	private String classtype;
	private String toobject;
	private Date time;
	public static  final Classinfo NULL =new ClassinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Classinfo load(Serializable id){
		ClassinfoManager classinfoManager = (ClassinfoManager)BeanUtil.load("classinfoManagerImpl");
		Classinfo classinfo=classinfoManager.get(id);
		return classinfo;

	}
	public  void setClassid(long classid){
		this.classid=classid;

	}
	@Id
	@Column(name="classId",length=22,nullable = false)
	public  long getClassid(){
		return this.classid;

	}
	public  void setClassname(String classname){
		this.classname=classname;

	}
	@Column(name="className",length=200)
	public  String getClassname(){
		return this.classname;

	}
	public  void setClassteacher(String classteacher){
		this.classteacher=classteacher;

	}
	@Column(name="classTeacher",length=40)
	public  String getClassteacher(){
		return this.classteacher;

	}
	public  void setClasstype(String classtype){
		this.classtype=classtype;

	}
	@Column(name="classType",length=100)
	public  String getClasstype(){
		return this.classtype;

	}
	public  void setToobject(String toobject){
		this.toobject=toobject;

	}
	@Column(name="toObject",length=40)
	public  String getToobject(){
		return this.toobject;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
}
