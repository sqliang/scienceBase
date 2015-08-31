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
@Table(name="admin")
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	private long userid;
	private String username;
	private String userpw;
	public static  final Admin NULL =new AdminNULL();

	public  void reloadForegnKey(){

	}
	public static  Admin load(Serializable id){
		AdminManager adminManager = (AdminManager)BeanUtil.load("adminManagerImpl");
		Admin admin=adminManager.get(id);
		return admin;

	}
	public  void setUserid(long userid){
		this.userid=userid;

	}
	@Id
	@Column(name="userId",length=22,nullable = false)
	public  long getUserid(){
		return this.userid;

	}
	public  void setUsername(String username){
		this.username=username;

	}
	@Column(name="userName",length=200)
	public  String getUsername(){
		return this.username;

	}
	public  void setUserpw(String userpw){
		this.userpw=userpw;

	}
	@Column(name="userPw",length=400)
	public  String getUserpw(){
		return this.userpw;

	}
}
