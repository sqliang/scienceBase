package com.science.domain;


import java.sql.*;

public class SubmenuNULL extends Submenu {


public  void setSubmenuid(long submenuid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setMainmenuid(long mainmenuid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setSubmenuname(String submenuname){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setSubmenulink(String submenulink){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "SubmenuNULL"+super.toString();

}
}
