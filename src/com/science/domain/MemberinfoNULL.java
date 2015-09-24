package com.science.domain;


import java.sql.*;

public class MemberinfoNULL extends Memberinfo {

	private static final long serialVersionUID = 1L;
	public  void setMemid(long memid){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setMemname(String memname){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setMemdegree(String memdegree){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setMemjobtitle(String memjobtitle){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setMemchenghao(String memchenghao){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setMemjobage(long memjobage){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setForeigntype(long foreigntype){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setForeginorgname(String foreginorgname){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setForeignurl(String foreignurl){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  String toString(){
		return "MemberinfoNULL"+super.toString();

	}
}
