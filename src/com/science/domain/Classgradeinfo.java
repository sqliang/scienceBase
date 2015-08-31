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
@Table(name="classgradeinfo")
public class Classgradeinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long gradeid;
	private String gradetitle;
	private String gradecontent;
	private Date time;
	public static  final Classgradeinfo NULL =new ClassgradeinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Classgradeinfo load(Serializable id){
		ClassgradeinfoManager classgradeinfoManager = (ClassgradeinfoManager)BeanUtil.load("classgradeinfoManagerImpl");
		Classgradeinfo classgradeinfo=classgradeinfoManager.get(id);
		return classgradeinfo;

	}
	public  void setGradeid(long gradeid){
		this.gradeid=gradeid;

	}
	@Id
	@Column(name="gradeId",length=22,nullable = false)
	public  long getGradeid(){
		return this.gradeid;

	}
	public  void setGradetitle(String gradetitle){
		this.gradetitle=gradetitle;

	}
	@Column(name="gradeTitle",length=200)
	public  String getGradetitle(){
		return this.gradetitle;

	}
	public  void setGradecontent(String gradecontent){
		this.gradecontent=gradecontent;

	}
	@Column(name="gradeContent",length=4000)
	public  String getGradecontent(){
		return this.gradecontent;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
}
