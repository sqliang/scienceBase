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
@Table(name="studentinfo")
public class Studentinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long stuid;
	private String stuname;
	private long stusex;
	private String studegree;
	private String stuteacher;
	private String stumaster;
	private String papertitle;
	private String sturesdirection;
	private String resinfocontent;
	public static  final Studentinfo NULL =new StudentinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Studentinfo load(Serializable id){
		StudentinfoManager studentinfoManager = (StudentinfoManager)BeanUtil.load("studentinfoManagerImpl");
		Studentinfo studentinfo=studentinfoManager.get(id);
		return studentinfo;

	}
	public  void setStuid(long stuid){
		this.stuid=stuid;

	}
	@Id
	@Column(name="stuId",length=22,nullable = false)
	public  long getStuid(){
		return this.stuid;

	}
	public  void setStuname(String stuname){
		this.stuname=stuname;

	}
	@Column(name="stuName",length=40)
	public  String getStuname(){
		return this.stuname;

	}
	public  void setStusex(long stusex){
		this.stusex=stusex;

	}
	@Column(name="stuSex",length=22)
	public  long getStusex(){
		return this.stusex;

	}
	public  void setStudegree(String studegree){
		this.studegree=studegree;

	}
	@Column(name="stuDegree",length=40)
	public  String getStudegree(){
		return this.studegree;

	}
	public  void setStuteacher(String stuteacher){
		this.stuteacher=stuteacher;

	}
	@Column(name="stuTeacher",length=40)
	public  String getStuteacher(){
		return this.stuteacher;

	}
	public  void setStumaster(String stumaster){
		this.stumaster=stumaster;

	}
	@Column(name="stuMaster",length=80)
	public  String getStumaster(){
		return this.stumaster;

	}
	public  void setPapertitle(String papertitle){
		this.papertitle=papertitle;

	}
	@Column(name="paperTitle",length=400)
	public  String getPapertitle(){
		return this.papertitle;

	}
	public  void setSturesdirection(String sturesdirection){
		this.sturesdirection=sturesdirection;

	}
	@Column(name="stuResDirection",length=200)
	public  String getSturesdirection(){
		return this.sturesdirection;

	}
	public  void setResinfocontent(String resinfocontent){
		this.resinfocontent=resinfocontent;

	}
	@Column(name="resInfoContent",length=4000)
	public  String getResinfocontent(){
		return this.resinfocontent;

	}
}
