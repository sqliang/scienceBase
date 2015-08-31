package com.science.domain;


import java.sql.*;

public class ClassinfoNULL extends Classinfo {


public  void setClassid(long classid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setClassname(String classname){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setClassteacher(String classteacher){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setClasstype(String classtype){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setToobject(String toobject){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "ClassinfoNULL"+super.toString();

}
}
