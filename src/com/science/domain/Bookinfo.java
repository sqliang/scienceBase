package com.science.domain;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Lob;
import com.science.util.json.JsonUtil;
import com.science.serviceManager.JManager;
import com.science.serviceManager.*;
import java.util.List;
import javax.persistence.Transient;
import java.util.ArrayList;
import com.science.util.bean.BeanUtil;

@Entity
@Table(name="bookinfo")
public class Bookinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long bookid;
	private String bookname;
	private String bookauthor;
	private String bookintro;
	private Date time;
	public static  final Bookinfo NULL =new BookinfoNULL();

	public  void reloadForegnKey(){

	}
	public static  Bookinfo load(Serializable id){
		BookinfoManager bookinfoManager = (BookinfoManager)BeanUtil.load("bookinfoManagerImpl");
		Bookinfo bookinfo=bookinfoManager.get(id);
		return bookinfo;

	}
	public  void setBookid(long bookid){
		this.bookid=bookid;

	}
	@Id
	@Column(name="bookId",length=22,nullable = false)
	public  long getBookid(){
		return this.bookid;

	}
	public  void setBookname(String bookname){
		this.bookname=bookname;

	}
	@Column(name="bookName",length=200)
	public  String getBookname(){
		return this.bookname;

	}
	public  void setBookauthor(String bookauthor){
		this.bookauthor=bookauthor;

	}
	@Column(name="bookAuthor",length=40)
	public  String getBookauthor(){
		return this.bookauthor;

	}
	public  void setBookintro(String bookintro){
		this.bookintro=bookintro;

	}
	@Column(name="bookIntro",length=4000)
	public  String getBookintro(){
		return this.bookintro;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
}
