package com.science.domain;


import java.sql.*;

public class ScienceeduNULL extends Scienceedu {


public  void setScienceid(long scienceid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setSciencetitle(String sciencetitle){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setContent(String content){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "ScienceeduNULL"+super.toString();

}
}
