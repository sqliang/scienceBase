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
@Table(name="scienceedu")
public class Scienceedu implements Serializable {

	private static final long serialVersionUID = 1L;

	private long scienceid;
	private String sciencetitle;
	private String content;
	private Date time;
	public static  final Scienceedu NULL =new ScienceeduNULL();

	public  void reloadForegnKey(){

	}
	public static  Scienceedu load(Serializable id){
		ScienceeduManager scienceeduManager = (ScienceeduManager)BeanUtil.load("scienceeduManagerImpl");
		Scienceedu scienceedu=scienceeduManager.get(id);
		return scienceedu;

	}
	public  void setScienceid(long scienceid){
		this.scienceid=scienceid;

	}
	@Id
	@Column(name="scienceId",length=22,nullable = false)
	public  long getScienceid(){
		return this.scienceid;

	}
	public  void setSciencetitle(String sciencetitle){
		this.sciencetitle=sciencetitle;

	}
	@Column(name="scienceTitle",length=200)
	public  String getSciencetitle(){
		return this.sciencetitle;

	}
	public  void setContent(String content){
		this.content=content;

	}
	@Column(name="content",length=4000)
	public  String getContent(){
		return this.content;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
}
