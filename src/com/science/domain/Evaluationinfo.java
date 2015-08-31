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
@Table(name="evaluationinfo")
public class Evaluationinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long evaluationid;
	private String evaluationtitle;
	private String uploadcontenturl;
	private Date time;
	public static  final Evaluationinfo NULL =new EvaluationinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Evaluationinfo load(Serializable id){
		EvaluationinfoManager evaluationinfoManager = (EvaluationinfoManager)BeanUtil.load("evaluationinfoManagerImpl");
		Evaluationinfo evaluationinfo=evaluationinfoManager.get(id);
		return evaluationinfo;

	}
	public  void setEvaluationid(long evaluationid){
		this.evaluationid=evaluationid;

	}
	@Id
	@Column(name="evaluationId",length=22,nullable = false)
	public  long getEvaluationid(){
		return this.evaluationid;

	}
	public  void setEvaluationtitle(String evaluationtitle){
		this.evaluationtitle=evaluationtitle;

	}
	@Column(name="evaluationTitle",length=40)
	public  String getEvaluationtitle(){
		return this.evaluationtitle;

	}
	public  void setUploadcontenturl(String uploadcontenturl){
		this.uploadcontenturl=uploadcontenturl;

	}
	@Column(name="uploadContentUrl",length=4000)
	public  String getUploadcontenturl(){
		return this.uploadcontenturl;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;
	}
	
}
