package com.science.domain;


import java.sql.*;

public class BookinfoNULL extends Bookinfo {


public  void setBookid(long bookid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setBookname(String bookname){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setBookauthor(String bookauthor){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setBookintro(String bookintro){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "BookinfoNULL"+super.toString();

}
}
