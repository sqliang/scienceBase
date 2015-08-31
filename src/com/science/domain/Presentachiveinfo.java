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
@Table(name="presentachiveinfo")
public class Presentachiveinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long presentachiveid;
	private String presentachivetitle;
	private String presentachivetype;
	private String presentachivecontent;
	private Date time;
	public static  final Presentachiveinfo NULL =new PresentachiveinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Presentachiveinfo load(Serializable id){
		PresentachiveinfoManager presentachiveinfoManager = (PresentachiveinfoManager)BeanUtil.load("presentachiveinfoManagerImpl");
		Presentachiveinfo presentachiveinfo=presentachiveinfoManager.get(id);
		return presentachiveinfo;

	}
	public  void setPresentachiveid(long presentachiveid){
		this.presentachiveid=presentachiveid;

	}
	@Id
	@Column(name="presentAchiveId",length=22,nullable = false)
	public  long getPresentachiveid(){
		return this.presentachiveid;

	}
	public  void setPresentachivetitle(String presentachivetitle){
		this.presentachivetitle=presentachivetitle;

	}
	@Column(name="presentAchiveTitle",length=200)
	public  String getPresentachivetitle(){
		return this.presentachivetitle;

	}
	public  void setPresentachivetype(String presentachivetype){
		this.presentachivetype=presentachivetype;

	}
	@Column(name="presentAchiveType",length=40)
	public  String getPresentachivetype(){
		return this.presentachivetype;

	}
	public  void setPresentachivecontent(String presentachivecontent){
		this.presentachivecontent=presentachivecontent;

	}
	@Column(name="presentAchiveContent",length=4000)
	public  String getPresentachivecontent(){
		return this.presentachivecontent;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
}
