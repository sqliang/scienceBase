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
@Table(name="introduceinfo")
public class Introduceinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long artid;
	private String arttitle;
	private long arttype;
	private String author;
	private String content;
	private String prictureurl1;
	private String pictureurl2;
	private String prictureurl3;
	private String videourl;
	private Date time;
	public static  final Introduceinfo NULL =new IntroduceinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Introduceinfo load(Serializable id){
		IntroduceinfoManager introduceinfoManager = (IntroduceinfoManager)BeanUtil.load("introduceinfoManagerImpl");
		Introduceinfo introduceinfo=introduceinfoManager.get(id);
		return introduceinfo;

	}
	public  void setArtid(long artid){
		this.artid=artid;

	}
	@Id
	@Column(name="artId",length=22,nullable = false)
	public  long getArtid(){
		return this.artid;

	}
	public  void setArttitle(String arttitle){
		this.arttitle=arttitle;

	}
	@Column(name="artTitle",length=400)
	public  String getArttitle(){
		return this.arttitle;

	}
	public  void setArttype(long arttype){
		this.arttype=arttype;

	}
	@Column(name="artType",length=22)
	public  long getArttype(){
		return this.arttype;

	}
	public  void setAuthor(String author){
		this.author=author;

	}
	@Column(name="author",length=40)
	public  String getAuthor(){
		return this.author;

	}
	public  void setContent(String content){
		this.content=content;

	}
	@Column(name="content",length=4000)
	public  String getContent(){
		return this.content;

	}
	public  void setPrictureurl1(String prictureurl1){
		this.prictureurl1=prictureurl1;

	}
	@Column(name="prictureUrl1",length=4000)
	public  String getPrictureurl1(){
		return this.prictureurl1;

	}
	public  void setPictureurl2(String pictureurl2){
		this.pictureurl2=pictureurl2;

	}
	@Column(name="pictureUrl2",length=4000)
	public  String getPictureurl2(){
		return this.pictureurl2;

	}
	public  void setPrictureurl3(String prictureurl3){
		this.prictureurl3=prictureurl3;

	}
	@Column(name="prictureUrl3",length=4000)
	public  String getPrictureurl3(){
		return this.prictureurl3;

	}
	public  void setVideourl(String videourl){
		this.videourl=videourl;

	}
	@Column(name="videoUrl",length=4000)
	public  String getVideourl(){
		return this.videourl;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
}
