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
@Table(name="leaderinfo")
public class Leaderinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long leaderid;
	private long memid;
	private long leadertype;
	private long position;
	private Date officedate;
	//对应主表：memberinfo
	private Memberinfo memberinfomemid;
	public static  final Leaderinfo NULL =new LeaderinfoNULL();

	public  Memberinfo loadMemberinfomemid(String... propertys){
		if(memberinfomemid==null){
			if (memid == 0) {
				return Memberinfo.NULL;
			}
			Memberinfo ret = Memberinfo.NULL;
			if(propertys!=null&&propertys.length!=0){
				StringBuffer hql = new StringBuffer("select ");
				for(int i = 0;i<propertys.length;i++){
					hql.append("a."+propertys[i]);
					if(i!=propertys.length-1){
						hql.append(",");
					}
				}
				hql.append(" from Memberinfo a where memid=?");
				JManager jManager = (JManager)BeanUtil.load("jManagerImpl");
				ret = (Memberinfo) JsonUtil.toBean(jManager.getJSONObject(hql.toString(), memid),Memberinfo.class);
			}else{
				MemberinfoManager memberinfoManager= (MemberinfoManager)BeanUtil.load("memberinfoManagerImpl");
				ret = (Memberinfo)memberinfoManager.get(new Long(memid));
			}
			if( ret != Memberinfo.NULL) {
				memberinfomemid = ret;
			}
			return ret;
		} else { return memberinfomemid; }

	}
	@Transient
	public  Memberinfo getMemberinfomemid(){
		return this.memberinfomemid;

	}
	public  void setMemberinfomemid(Memberinfo memberinfomemid){
		this.memberinfomemid=memberinfomemid;

	}
	public  void reloadForegnKey(){

	}
	public static  Leaderinfo load(Serializable id){
		LeaderinfoManager leaderinfoManager = (LeaderinfoManager)BeanUtil.load("leaderinfoManagerImpl");
		Leaderinfo leaderinfo=leaderinfoManager.get(id);
		return leaderinfo;

	}
	public  void setLeaderid(long leaderid){
		this.leaderid=leaderid;

	}
	@Id
	@Column(name="leaderId",length=22,nullable = false)
	public  long getLeaderid(){
		return this.leaderid;

	}
	public  void setMemid(long memid){
		if(this.memid != memid){
			memberinfomemid = null;
		}
		this.memid=memid;

	}
	@Column(name="memId",length=22)
	public  long getMemid(){
		return this.memid;

	}
	public  void setLeadertype(long leadertype){
		this.leadertype=leadertype;

	}
	@Column(name="leaderType",length=22)
	public  long getLeadertype(){
		return this.leadertype;

	}
	public  void setPosition(long position){
		this.position=position;

	}
	@Column(name="position",length=22)
	public  long getPosition(){
		return this.position;

	}
	public  void setOfficedate(Date officedate){
		this.officedate=officedate;

	}
	@Column(name="officeDate",length=7)
	public  Date getOfficedate(){
		return this.officedate;

	}
}
