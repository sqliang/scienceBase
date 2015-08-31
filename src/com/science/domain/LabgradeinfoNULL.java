package com.science.domain;


import java.sql.*;

public class LabgradeinfoNULL extends Labgradeinfo {


public  void setLabgradeid(long labgradeid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setGradename(String gradename){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setGradedengji(String gradedengji){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setGradetype(String gradetype){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setGradefinish(String gradefinish){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "LabgradeinfoNULL"+super.toString();

}
}
