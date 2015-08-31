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
@Table(name="mainmenu")
public class Mainmenu implements Serializable {

	private static final long serialVersionUID = 1L;

	private long mainmenuid;
	private String mainmenuname;
	private String mainmenulink;
	//对应从表：Submenu
	private List<Submenu> submenumainmenuids;
	public static  final Mainmenu NULL =new MainmenuNULL();

	public  List<Submenu> loadSubmenumainmenuids(String sqlkey,String... propertys){
		SubmenuManager submenuManager = (SubmenuManager)BeanUtil.load("submenuManagerImpl");
		if(submenumainmenuids==null){
			if (mainmenuid == 0) {
				submenumainmenuids = new ArrayList();
			} else {
				if(propertys!=null&&propertys.length!=0){
					StringBuffer hql = new StringBuffer("select  ");
					for(int i = 0;i<propertys.length;i++){
						hql.append("a."+propertys[i]);
						if(i!=propertys.length-1){
							hql.append(",");
						}
					}
					hql.append(" from Submenu a where mainmenuid = ?");
					JManager jManager = (JManager)BeanUtil.load("jManagerImpl");
					submenumainmenuids = (List<Submenu>) JsonUtil.toList(jManager.getJsonArray(hql.toString(), mainmenuid),Submenu.class);
				}else{

					submenumainmenuids = submenuManager.findbyHql(" and mainmenuid="+mainmenuid + sqlkey);
				}
			}
		}
		return submenumainmenuids;

	}
	@Transient
	public  List<Submenu> getSubmenumainmenuids(){
		return this.submenumainmenuids;

	}
	public  void setSubmenumainmenuids(List<Submenu> submenumainmenuids){
		this.submenumainmenuids=submenumainmenuids;

	}
	public  void reloadForegnKey(){
		if(submenumainmenuids!=null){
			for(Submenu submenu : submenumainmenuids){
				submenu.setMainmenuid(mainmenuid);
			}
		}

	}
	public static  Mainmenu load(Serializable id){
		MainmenuManager mainmenuManager = (MainmenuManager)BeanUtil.load("mainmenuManagerImpl");
		Mainmenu mainmenu=mainmenuManager.get(id);
		return mainmenu;

	}
	public  void setMainmenuid(long mainmenuid){
		this.mainmenuid=mainmenuid;

	}
	@Id
	@Column(name="mainMenuId",length=22,nullable = false)
	public  long getMainmenuid(){
		return this.mainmenuid;

	}
	public  void setMainmenuname(String mainmenuname){
		this.mainmenuname=mainmenuname;

	}
	@Column(name="mainMenuName",length=40)
	public  String getMainmenuname(){
		return this.mainmenuname;

	}
	public  void setMainmenulink(String mainmenulink){
		this.mainmenulink=mainmenulink;

	}
	@Column(name="mainMenuLink",length=4000)
	public  String getMainmenulink(){
		return this.mainmenulink;

	}
}
