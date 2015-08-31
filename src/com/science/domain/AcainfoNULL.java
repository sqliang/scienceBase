package com.science.domain;


import java.sql.*;

public class AcainfoNULL extends Acainfo {


	public  void setAcaid(long acaid){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setAcaname(String acaname){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setAcasex(long acasex){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setAcaage(long acaage){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setPosition(long position){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setAcatype(long acatype){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setOfficedate(Date officedate){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setIntrurl(String intrurl){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  String toString(){
		return "AcainfoNULL"+super.toString();

	}
}
