package com.science.domain;


import java.sql.*;

public class MagsysinfoNULL extends Magsysinfo {


public  void setMagsysid(long magsysid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setMagsystitle(String magsystitle){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setMagsyscontent(String magsyscontent){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setTime(Date time){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "MagsysinfoNULL"+super.toString();

}
}
