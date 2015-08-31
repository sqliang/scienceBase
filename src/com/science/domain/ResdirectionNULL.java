package com.science.domain;


import java.sql.*;

public class ResdirectionNULL extends Resdirection {


public  void setDirid(long dirid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setDirtitle(String dirtitle){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setTime(Date time){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setContent(String content){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "ResdirectionNULL"+super.toString();

}
}
