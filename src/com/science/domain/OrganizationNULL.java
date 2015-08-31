package com.science.domain;


import java.sql.*;

public class OrganizationNULL extends Organization {


public  void setOrgid(long orgid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setOrgtitle(String orgtitle){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setTime(Date time){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setContent(String content){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "OrganizationNULL"+super.toString();

}
}
