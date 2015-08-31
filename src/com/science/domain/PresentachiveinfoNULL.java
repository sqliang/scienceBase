package com.science.domain;


import java.sql.*;

public class PresentachiveinfoNULL extends Presentachiveinfo {


public  void setPresentachiveid(long presentachiveid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPresentachivetitle(String presentachivetitle){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPresentachivetype(String presentachivetype){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPresentachivecontent(String presentachivecontent){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "PresentachiveinfoNULL"+super.toString();

}
}
