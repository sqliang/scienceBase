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
@Table(name="submenu")
public class Submenu implements Serializable {

	private static final long serialVersionUID = 1L;

	private long submenuid;
	private long mainmenuid;
	private String submenuname;
	private String submenulink;
	//对应主表：mainmenu
	private Mainmenu mainmenumainmenuid;
	public static  final Submenu NULL =new SubmenuNULL();

	public  Mainmenu loadMainmenumainmenuid(String... propertys){
		if(mainmenumainmenuid==null){
			if (mainmenuid == 0) {
				return Mainmenu.NULL;
			}
			Mainmenu ret = Mainmenu.NULL;
			if(propertys!=null&&propertys.length!=0){
				StringBuffer hql = new StringBuffer("select  ");
				for(int i = 0;i<propertys.length;i++){
					hql.append("a."+propertys[i]);
					if(i!=propertys.length-1){
						hql.append(",");
					}
				}
				hql.append(" from Mainmenu a where mainmenuid = ?");
				JManager jManager = (JManager)BeanUtil.load("jManagerImpl");
				ret = (Mainmenu) JsonUtil.toBean(jManager.getJSONObject(hql.toString(), mainmenuid),Mainmenu.class);
			}else{
				MainmenuManager mainmenuManager= (MainmenuManager)BeanUtil.load("mainmenuManagerImpl");
				ret = (Mainmenu)mainmenuManager.get(new Long(mainmenuid));
			}
			if( ret != Mainmenu.NULL) {
				mainmenumainmenuid = ret;
			}
			return ret;
		} else { return mainmenumainmenuid; }

	}
	@Transient
	public  Mainmenu getMainmenumainmenuid(){
		return this.mainmenumainmenuid;

	}
	public  void setMainmenumainmenuid(Mainmenu mainmenumainmenuid){
		this.mainmenumainmenuid=mainmenumainmenuid;

	}
	public  void reloadForegnKey(){

	}
	public static  Submenu load(Serializable id){
		SubmenuManager submenuManager = (SubmenuManager)BeanUtil.load("submenuManagerImpl");
		Submenu submenu=submenuManager.get(id);
		return submenu;

	}
	public  void setSubmenuid(long submenuid){
		this.submenuid=submenuid;

	}
	@Id
	@Column(name="subMenuId",length=22,nullable = false)
	public  long getSubmenuid(){
		return this.submenuid;

	}
	public  void setMainmenuid(long mainmenuid){
		if(this.mainmenuid != mainmenuid){
			mainmenumainmenuid = null;
		}
		this.mainmenuid=mainmenuid;

	}
	@Column(name="mainMenuId",length=22)
	public  long getMainmenuid(){
		return this.mainmenuid;

	}
	public  void setSubmenuname(String submenuname){
		this.submenuname=submenuname;

	}
	@Column(name="subMenuName",length=80)
	public  String getSubmenuname(){
		return this.submenuname;

	}
	public  void setSubmenulink(String submenulink){
		this.submenulink=submenulink;

	}
	@Column(name="subMenuLink",length=4000)
	public  String getSubmenulink(){
		return this.submenulink;

	}
}
