package com.science.domain;


import java.sql.*;

public class ClassgradeinfoNULL extends Classgradeinfo {


public  void setGradeid(long gradeid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setGradetitle(String gradetitle){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setGradecontent(String gradecontent){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setTime(Date time){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "ClassgradeinfoNULL"+super.toString();

}
}
