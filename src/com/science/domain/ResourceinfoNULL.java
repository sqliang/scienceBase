package com.science.domain;


import java.sql.*;

public class ResourceinfoNULL extends Resourceinfo {


public  void setResourceid(long resourceid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setResourcetype(long resourcetype){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setSharemethod(String sharemethod){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setUseintroduce(String useintroduce){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setUsedinfo(String usedinfo){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "ResourceinfoNULL"+super.toString();

}
}
