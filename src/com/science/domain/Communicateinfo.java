
package com.science.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.science.serviceManager.AcainfoManager;
import com.science.serviceManager.CommunicateinfoManager;
import com.science.util.bean.BeanUtil;

@Entity
@Table(name="communicateinfo")
public class Communicateinfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long communicateid;
	private String communicatetitle;
	private long communicatetype;
	private String communicatecontent;
	private Date time;
	public static  final CommunicateinfoNULL NULL =new CommunicateinfoNULL();

	public  void reloadForegnKey(){

	}

	public static Communicateinfo load(Serializable id){
		CommunicateinfoManager communicateinfoManager = (CommunicateinfoManager) BeanUtil.load("communicateinfoManagerImpl");
		Communicateinfo communicateinfo = communicateinfoManager.get(id);
		return communicateinfo;

	}
	@Id
	@Column(name="communicateId",length=22,nullable = false)
	public long getCommunicateid() {
		return communicateid;
	}

	public void setCommunicateid(long communicateid) {
		this.communicateid = communicateid;
	}
	@Column(name="communicateTitle",length=200)
	public String getCommunicatetitle() {
		return communicatetitle;
	}

	public void setCommunicatetitle(String communicatetitle) {
		this.communicatetitle = communicatetitle;
	}
	@Column(name="communicateType",length=22)
	public long getCommunicatetype() {
		return communicatetype;
	}

	public void setCommunicatetype(long communicatetype) {
		this.communicatetype = communicatetype;
	}
	@Column(name="communicateContent",length=4000)
	public String getCommunicatecontent() {
		return communicatecontent;
	}

	public void setCommunicatecontent(String communicatecontent) {
		this.communicatecontent = communicatecontent;
	}
	@Column(name="time",length=7)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
