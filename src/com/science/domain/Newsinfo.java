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
@Table(name="newsinfo")
public class Newsinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long newsid;
	private String newstitle;
	private String author;
	private String newscontent;
	private long newstype;//新闻类别：:1，新闻；2，公告；3，学术报告；4，学术动态
	private long status;//是否设为焦点图片新闻，0代表一般，1代表焦点
	private Date time;
	private String pictureurl1;
	private String pictureurl2;
	private String pictureurl3;
	private String videourl;
	//对应从表：Picnews
	private List<Picnews> picnewsnewsids;
	public static  final Newsinfo NULL =new NewsinfoNULL();

	public  List<Picnews> loadPicnewsnewsids(String sqlkey,String... propertys){
		PicnewsManager picnewsManager = (PicnewsManager)BeanUtil.load("picnewsManagerImpl");
		if(picnewsnewsids==null){
			if (newsid == 0) {
				picnewsnewsids = new ArrayList();
			} else {
				if(propertys!=null&&propertys.length!=0){
					StringBuffer hql = new StringBuffer("select  ");
					for(int i = 0;i<propertys.length;i++){
						hql.append("a."+propertys[i]);
						if(i!=propertys.length-1){
							hql.append(",");
						}
					}
					hql.append(" from Picnews a where newsid = ?");
					JManager jManager = (JManager)BeanUtil.load("jManagerImpl");
					picnewsnewsids = (List<Picnews>) JsonUtil.toList(jManager.getJsonArray(hql.toString(), newsid),Picnews.class);
				}else{

					picnewsnewsids = picnewsManager.findbyHql(" and newsid="+newsid + sqlkey);
				}
			}
		}
		return picnewsnewsids;

	}
	@Transient
	public  List<Picnews> getPicnewsnewsids(){
		return this.picnewsnewsids;

	}
	public  void setPicnewsnewsids(List<Picnews> picnewsnewsids){
		this.picnewsnewsids=picnewsnewsids;

	}
	public  void reloadForegnKey(){
		if(picnewsnewsids!=null){
			for(Picnews picnews : picnewsnewsids){
				picnews.setNewsid(newsid);
			}
		}

	}
	public static  Newsinfo load(Serializable id){
		NewsinfoManager newsinfoManager = (NewsinfoManager)BeanUtil.load("newsinfoManagerImpl");
		Newsinfo newsinfo=newsinfoManager.get(id);
		return newsinfo;

	}
	public  void setNewsid(long newsid){
		this.newsid=newsid;

	}
	@Id
	@Column(name="newsId",length=22,nullable = false)
	public  long getNewsid(){
		return this.newsid;

	}
	public  void setNewstitle(String newstitle){
		this.newstitle=newstitle;

	}
	@Column(name="newsTitle",length=400)
	public  String getNewstitle(){
		return this.newstitle;

	}
	public  void setAuthor(String author){
		this.author=author;

	}
	@Column(name="author",length=40)
	public  String getAuthor(){
		return this.author;

	}
	public  void setNewscontent(String newscontent){
		this.newscontent=newscontent;

	}
	@Column(name="newsContent",length=4000)
	public  String getNewscontent(){
		return this.newscontent;

	}
	public  void setNewstype(long newstype){
		this.newstype=newstype;

	}
	@Column(name="newsType",length=22)
	public  long getNewstype(){
		return this.newstype;

	}
	public  void setStatus(long status){
		this.status=status;

	}
	@Column(name="status",length=22)
	public  long getStatus(){
		return this.status;

	}
	public  void setTime(Date time){
		this.time=time;

	}
	@Column(name="time",length=7)
	public  Date getTime(){
		return this.time;

	}
	public  void setPictureurl1(String pictureurl1){
		this.pictureurl1=pictureurl1;

	}
	@Column(name="pictureUrl1",length=4000)
	public  String getPictureurl1(){
		return this.pictureurl1;

	}
	public  void setPictureurl2(String pictureurl2){
		this.pictureurl2=pictureurl2;

	}
	@Column(name="pictureUrl2",length=4000)
	public  String getPictureurl2(){
		return this.pictureurl2;

	}
	public  void setPictureurl3(String pictureurl3){
		this.pictureurl3=pictureurl3;

	}
	@Column(name="pictureUrl3",length=4000)
	public  String getPictureurl3(){
		return this.pictureurl3;

	}
	public  void setVideourl(String videourl){
		this.videourl=videourl;

	}
	@Column(name="videoUrl",length=4000)
	public  String getVideourl(){
		return this.videourl;

	}
}
