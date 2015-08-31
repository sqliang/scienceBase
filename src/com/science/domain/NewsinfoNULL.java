package com.science.domain;


import java.sql.*;

public class NewsinfoNULL extends Newsinfo {


	public  void setNewsid(long newsid){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setNewstitle(String newstitle){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setAuthor(String author){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setNewscontent(String newscontent){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setNewstype(long newstype){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setStatus(long status){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setTime(Date time){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setPictureurl1(String pictureurl1){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setPictureurl2(String pictureurl2){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setPictureurl3(String pictureurl3){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  void setVideourl(String videourl){
		throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

	}
	public  String toString(){
		return "NewsinfoNULL"+super.toString();

	}
}
