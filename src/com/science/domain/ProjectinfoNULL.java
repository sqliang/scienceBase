package com.science.domain;


import java.sql.*;

public class ProjectinfoNULL extends Projectinfo {


public  void setProjid(long projid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setProjcode(String projcode){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setProjname(String projname){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setProjtype(String projtype){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setProjagreeorg(String projagreeorg){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setProjmasterperson(String projmasterperson){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setProjstarttime(Date projstarttime){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setProjendtime(Date projendtime){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setProjfee(String projfee){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "ProjectinfoNULL"+super.toString();

}
}
