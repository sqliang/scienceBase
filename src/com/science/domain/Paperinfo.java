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
@Table(name="paperinfo")
public class Paperinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long paperid;
	private String papername;
	private String paperauthor;
	private String paperjounal;
	private String journalinfo;
	private String paperinclude;
	private Date time;
	public static  final Paperinfo NULL =new PaperinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Paperinfo load(Serializable id){
		PaperinfoManager paperinfoManager = (PaperinfoManager)BeanUtil.load("paperinfoManagerImpl");
		Paperinfo paperinfo=paperinfoManager.get(id);
		return paperinfo;

	}
	public  void setPaperid(long paperid){
		this.paperid=paperid;

	}
	@Id
	@Column(name="paperId",length=22,nullable = false)
	public  long getPaperid(){
		return this.paperid;

	}
	public  void setPapername(String papername){
		this.papername=papername;

	}
	@Column(name="paperName",length=400)
	public  String getPapername(){
		return this.papername;

	}
	public  void setPaperauthor(String paperauthor){
		this.paperauthor=paperauthor;

	}
	@Column(name="paperAuthor",length=400)
	public  String getPaperauthor(){
		return this.paperauthor;

	}
	public  void setPaperjounal(String paperjounal){
		this.paperjounal=paperjounal;

	}
	@Column(name="paperJounal",length=400)
	public  String getPaperjounal(){
		return this.paperjounal;

	}
	public  void setJournalinfo(String journalinfo){
		this.journalinfo=journalinfo;

	}
	@Column(name="JournalInfo",length=400)
	public  String getJournalinfo(){
		return this.journalinfo;

	}
	public  void setPaperinclude(String paperinclude){
		this.paperinclude=paperinclude;

	}
	@Column(name="paperInclude",length=4000)
	public  String getPaperinclude(){
		return this.paperinclude;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
}
