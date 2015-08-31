package com.science.domain;


import java.sql.*;

public class AdminNULL extends Admin {


public  void setUserid(long userid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setUsername(String username){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setUserpw(String userpw){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "AdminNULL"+super.toString();

}
}
