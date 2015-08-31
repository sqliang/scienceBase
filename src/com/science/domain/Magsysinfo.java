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
@Table(name="magsysinfo")
public class Magsysinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long magsysid;
	private String magsystitle;
	private String magsyscontent;
	private Date time;
	public static  final Magsysinfo NULL =new MagsysinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Magsysinfo load(Serializable id){
		MagsysinfoManager magsysinfoManager = (MagsysinfoManager)BeanUtil.load("magsysinfoManagerImpl");
		Magsysinfo magsysinfo=magsysinfoManager.get(id);
		return magsysinfo;

	}
	public  void setMagsysid(long magsysid){
		this.magsysid=magsysid;

	}
	@Id
	@Column(name="magSysId",length=22,nullable = false)
	public  long getMagsysid(){
		return this.magsysid;

	}
	public  void setMagsystitle(String magsystitle){
		this.magsystitle=magsystitle;

	}
	@Column(name="magSysTitle",length=200)
	public  String getMagsystitle(){
		return this.magsystitle;

	}
	public  void setMagsyscontent(String magsyscontent){
		this.magsyscontent=magsyscontent;

	}
	@Column(name="magSysContent",length=4000)
	public  String getMagsyscontent(){
		return this.magsyscontent;
	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
}
