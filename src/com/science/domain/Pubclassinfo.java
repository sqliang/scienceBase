package com.science.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.science.serviceManager.AcainfoManager;
import com.science.serviceManager.PubclassinfoManager;
import com.science.util.bean.BeanUtil;

@Entity
@Table(name = "pubclassinfo")
public class Pubclassinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long pubclassid;
	private String pubclasstitle;
	private String pubclasscontent;
	private Date time;
	
	public  void reloadForegnKey(){

	}
	
	public static  Pubclassinfo load(Serializable id){
		PubclassinfoManager puclassinfoManager = (PubclassinfoManager)BeanUtil.load("puclassinfoManagerImpl");
		Pubclassinfo pubclassinfo=puclassinfoManager.get(id);
		return pubclassinfo;

	}
	@Id
	@Column(name="pubClassId",length=22,nullable = false)
	public long getPubclassid() {
		return pubclassid;
	}

	public void setPubclassid(long pubclassid) {
		this.pubclassid = pubclassid;
	}
	@Column(name="pubClassTitle",length=200)
	public String getPubclasstitle() {
		return pubclasstitle;
	}

	public void setPubclasstitle(String pubclasstitle) {
		this.pubclasstitle = pubclasstitle;
	}
	@Column(name="pubClassContent",length=4000)
	public String getPubclasscontent() {
		return pubclasscontent;
	}

	public void setPubclasscontent(String pubclasscontent) {
		this.pubclasscontent = pubclasscontent;
	}
	@Column(name="time",length=7)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
