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
@Table(name="resdirection")
public class Resdirection implements Serializable {

	private static final long serialVersionUID = 1L;

	private long dirid;
	private String dirtitle;
	private Date time;
	private String content;
	public static  final Resdirection NULL =new ResdirectionNULL();

	public  void reloadForegnKey(){

	}
	public static  Resdirection load(Serializable id){
		ResdirectionManager resdirectionManager = (ResdirectionManager)BeanUtil.load("resdirectionManagerImpl");
		Resdirection resdirection=resdirectionManager.get(id);
		return resdirection;

	}
	public  void setDirid(long dirid){
		this.dirid=dirid;

	}
	@Id
	@Column(name="dirId",length=22,nullable = false)
	public  long getDirid(){
		return this.dirid;

	}
	public  void setDirtitle(String dirtitle){
		this.dirtitle=dirtitle;

	}
	@Column(name="dirTitle",length=200)
	public  String getDirtitle(){
		return this.dirtitle;

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
