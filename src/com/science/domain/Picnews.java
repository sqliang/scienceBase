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
@Table(name="picnews")
public class Picnews implements Serializable {

	private static final long serialVersionUID = 1L;

	private long picnewsid;
	private long newsid;
	private String imgurl;
	//对应主表：newsinfo
	private Newsinfo newsinfonewsid;
	public static  final Picnews NULL =new PicnewsNULL();

	public  Newsinfo loadNewsinfonewsid(String... propertys){
		if(newsinfonewsid==null){
			if (newsid == 0) {
				return Newsinfo.NULL;
			}
			Newsinfo ret = Newsinfo.NULL;
			if(propertys!=null&&propertys.length!=0){
				StringBuffer hql = new StringBuffer("select  ");
				for(int i = 0;i<propertys.length;i++){
					hql.append("a."+propertys[i]);
					if(i!=propertys.length-1){
						hql.append(",");
					}
				}
				hql.append(" from Newsinfo a where newsid = ?");
				JManager jManager = (JManager)BeanUtil.load("jManagerImpl");
				ret = (Newsinfo) JsonUtil.toBean(jManager.getJSONObject(hql.toString(), newsid),Newsinfo.class);
			}else{
				NewsinfoManager newsinfoManager= (NewsinfoManager)BeanUtil.load("newsinfoManagerImpl");
				ret = (Newsinfo)newsinfoManager.get(new Long(newsid));
			}
			if( ret != Newsinfo.NULL) {
				newsinfonewsid = ret;
			}
			return ret;
		} else { return newsinfonewsid; }

	}
	@Transient
	public  Newsinfo getNewsinfonewsid(){
		return this.newsinfonewsid;

	}
	public  void setNewsinfonewsid(Newsinfo newsinfonewsid){
		this.newsinfonewsid=newsinfonewsid;

	}
	public  void reloadForegnKey(){

	}
	public static  Picnews load(Serializable id){
		PicnewsManager picnewsManager = (PicnewsManager)BeanUtil.load("picnewsManagerImpl");
		Picnews picnews=picnewsManager.get(id);
		return picnews;

	}
	public  void setPicnewsid(long picnewsid){
		this.picnewsid=picnewsid;

	}
	@Id
	@Column(name="picNewsId",length=22,nullable = false)
	public  long getPicnewsid(){
		return this.picnewsid;

	}
	public  void setNewsid(long newsid){
		if(this.newsid != newsid){
			newsinfonewsid = null;
		}
		this.newsid=newsid;

	}
	@Column(name="newsId",length=22)
	public  long getNewsid(){
		return this.newsid;

	}
	public  void setImgurl(String imgurl){
		this.imgurl=imgurl;

	}
	@Column(name="imgUrl",length=4000)
	public  String getImgurl(){
		return this.imgurl;

	}
}
