package com.science.serviceManagerImpl;


import com.science.domain.Mainmenu;
import com.science.serviceManager.MainmenuManager;
import com.science.dao.MainmenuDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class MainmenuManagerImpl extends BaseManagerImpl<Mainmenu> implements MainmenuManager {

	private MainmenuDao mainmenuDao;

	@Autowired
	public  void setMainmenuDao(MainmenuDao mainmenuDao){
		this.mainmenuDao=mainmenuDao;
		super.baseDao = mainmenuDao;
		this.mainmenuDao=mainmenuDao;


	}
	public  void addMainmenu(Mainmenu mainmenu){
		save(mainmenu);
	}
	public  void addMainmenus(List<Mainmenu> mainmenus){
		save(mainmenus);
	}
	public  Mainmenu load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Mainmenu> find(String sqlkey){
		return findbyHql(sqlkey);
		
	}
	public List<Mainmenu> queryMainmenuContainSub(){
		List<Mainmenu> mainmenus = findbyHql("from Mainmenu order by mainmenuid ASC");
		for(Mainmenu mainmenu : mainmenus){
			mainmenu.loadSubmenumainmenuids("");
		}
		return mainmenus;
	}
}
