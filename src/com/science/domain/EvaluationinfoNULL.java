package com.science.domain;


import java.sql.*;

public class EvaluationinfoNULL extends Evaluationinfo {


public  void setEvaluationid(long evaluationid){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setEvaluationtitle(String evaluationtitle){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  void setUploadcontenturl(String uploadcontenturl){
throw new IllegalArgumentException("试图向NULLVO设置数据，NULLVO不允许此操作！");

}
public  String toString(){
 return "EvaluationinfoNULL"+super.toString();

}
}
