package com.science.domain;


import java.sql.*;

public class PaptentinfoNULL extends Paptentinfo {


public  void setPaptentid(long paptentid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPaptentname(String paptentname){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPaptenttype(String paptenttype){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPaptentauthors(String paptentauthors){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setAgreetime(Date agreetime){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPaptentstatus(String paptentstatus){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "PaptentinfoNULL"+super.toString();

}
}
