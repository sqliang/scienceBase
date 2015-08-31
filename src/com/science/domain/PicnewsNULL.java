package com.science.domain;


import java.sql.*;

public class PicnewsNULL extends Picnews {


public  void setPicnewsid(long picnewsid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setNewsid(long newsid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setImgurl(String imgurl){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "PicnewsNULL"+super.toString();

}
}
