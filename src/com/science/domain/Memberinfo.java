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
@Table(name="memberinfo")
public class Memberinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long memid;
	private String memname;
	private long memsex;
	private long memage;
	private String memdegree;
	private String memjobtitle;
	private String memtype;
	private String memchenghao;
	private long memjobage;
	private long foreigntype;
	private String foreginorgname;
	private String foreignurl;
	//对应从表：Leaderinfo
	private List<Leaderinfo> leaderinfomemids;
	public static  final Memberinfo NULL =new MemberinfoNULL();

	public  List<Leaderinfo> loadLeaderinfomemids(String sqlkey,String... propertys){
		LeaderinfoManager leaderinfoManager = (LeaderinfoManager)BeanUtil.load("leaderinfoManagerImpl");
		if(leaderinfomemids==null){
			if (memid == 0) {
				leaderinfomemids = new ArrayList();
			} else {
				if(propertys!=null&&propertys.length!=0){
					StringBuffer hql = new StringBuffer("select  ");
					for(int i = 0;i<propertys.length;i++){
						hql.append("a."+propertys[i]);
						if(i!=propertys.length-1){
							hql.append(",");
						}
					}
					hql.append(" from Leaderinfo a where memid = ?");
					JManager jManager = (JManager)BeanUtil.load("jManagerImpl");
					leaderinfomemids = (List<Leaderinfo>) JsonUtil.toList(jManager.getJsonArray(hql.toString(), memid),Leaderinfo.class);
				}else{

					leaderinfomemids = leaderinfoManager.findbyHql(" and memid="+memid + sqlkey);
				}
			}
		}
		return leaderinfomemids;

	}
	@Transient
	public  List<Leaderinfo> getLeaderinfomemids(){
		return this.leaderinfomemids;

	}
	public  void setLeaderinfomemids(List<Leaderinfo> leaderinfomemids){
		this.leaderinfomemids=leaderinfomemids;

	}
	public  void reloadForegnKey(){
		if(leaderinfomemids!=null){
			for(Leaderinfo leaderinfo : leaderinfomemids){
				leaderinfo.setMemid(memid);
			}
		}

	}
	public static  Memberinfo load(Serializable id){
		MemberinfoManager memberinfoManager = (MemberinfoManager)BeanUtil.load("memberinfoManagerImpl");
		Memberinfo memberinfo=memberinfoManager.get(id);
		return memberinfo;

	}
	public  void setMemid(long memid){
		this.memid=memid;

	}
	@Id
	@Column(name="memId",length=22,nullable = false)
	public  long getMemid(){
		return this.memid;

	}
	public  void setMemname(String memname){
		this.memname=memname;

	}
	@Column(name="memName",length=40)
	public  String getMemname(){
		return this.memname;

	}
	public  void setMemsex(long memsex){
		this.memsex=memsex;

	}
	@Column(name="memSex",length=22)
	public  long getMemsex(){
		return this.memsex;

	}
	public  void setMemage(long memage){
		this.memage=memage;

	}
	@Column(name="memAge",length=22)
	public  long getMemage(){
		return this.memage;

	}
	public  void setMemdegree(String memdegree){
		this.memdegree=memdegree;

	}
	@Column(name="memDegree",length=20)
	public  String getMemdegree(){
		return this.memdegree;

	}
	public  void setMemjobtitle(String memjobtitle){
		this.memjobtitle=memjobtitle;

	}
	@Column(name="memJobTitle",length=20)
	public  String getMemjobtitle(){
		return this.memjobtitle;

	}
	public  void setMemchenghao(String memchenghao){
		this.memchenghao=memchenghao;

	}
	@Column(name="memChengHao",length=100)
	public  String getMemchenghao(){
		return this.memchenghao;

	}
	public  void setMemjobage(long memjobage){
		this.memjobage=memjobage;

	}
	@Column(name="memJobAge",length=22)
	public  long getMemjobage(){
		return this.memjobage;

	}
	public  void setForeigntype(long foreigntype){
		this.foreigntype=foreigntype;

	}
	@Column(name="foreignType",length=22)
	public  long getForeigntype(){
		return this.foreigntype;

	}
	public  void setForeginorgname(String foreginorgname){
		this.foreginorgname=foreginorgname;

	}
	@Column(name="foreginOrgName",length=400)
	public  String getForeginorgname(){
		return this.foreginorgname;

	}
	public  void setForeignurl(String foreignurl){
		this.foreignurl=foreignurl;

	}
	@Column(name="foreignUrl",length=4000)
	public  String getForeignurl(){
		return this.foreignurl;

	}
	@Column(name="memType",length=20)
	public String getMemtype() {
		return memtype;
	}
	public void setMemtype(String memtype) {
		this.memtype = memtype;
	}
}
