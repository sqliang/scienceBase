package com.science.domain;


import java.sql.*;

public class MainmenuNULL extends Mainmenu {


public  void setMainmenuid(long mainmenuid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setMainmenuname(String mainmenuname){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setMainmenulink(String mainmenulink){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "MainmenuNULL"+super.toString();

}
}
