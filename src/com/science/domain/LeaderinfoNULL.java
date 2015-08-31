package com.science.domain;


import java.sql.*;

public class LeaderinfoNULL extends Leaderinfo {


public  void setLeaderid(long leaderid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setMemid(long memid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setLeadertype(long leadertype){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPosition(long position){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setOfficedate(Date officedate){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "LeaderinfoNULL"+super.toString();

}
}
