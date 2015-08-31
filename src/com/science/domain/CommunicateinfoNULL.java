package com.science.domain;

import java.sql.Date;

public class CommunicateinfoNULL extends Communicateinfo {
	
	public void setCommunicateid(long communicateid){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");
	}
	
	public void setCommunicatetitle(String communicatetitle){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");
	}
	public void setCommunicatetype(long communicatetype){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");
	}
	public void setCommunicatecontent(String communicatecontent){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");
	}
	public  void setTime(Date time){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  String toString(){
		return "CommunicateinfoNULL"+super.toString();

	}
}
