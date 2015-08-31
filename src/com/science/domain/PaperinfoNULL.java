package com.science.domain;


import java.sql.*;

public class PaperinfoNULL extends Paperinfo {


public  void setPaperid(long paperid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPapername(String papername){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPaperauthor(String paperauthor){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPaperjounal(String paperjounal){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setJournalinfo(String journalinfo){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setPaperinclude(String paperinclude){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "PaperinfoNULL"+super.toString();

}
}
