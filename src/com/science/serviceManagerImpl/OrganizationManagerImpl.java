package com.science.serviceManagerImpl;


import com.science.domain.Organization;
import com.science.serviceManager.OrganizationManager;
import com.science.dao.OrganizationDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class OrganizationManagerImpl extends BaseManagerImpl<Organization> implements OrganizationManager {

	private OrganizationDao organizationDao;

	@Autowired
	public  void setOrganizationDao(OrganizationDao organizationDao){
		this.organizationDao=organizationDao;
		super.baseDao = organizationDao;
		this.organizationDao=organizationDao;


	}
	public  void addOrganization(Organization organization){
		save(organization);
	}
	public  void addOrganizations(List<Organization> organizations){
		save(organizations);
	}
	public  Organization load(String sqlkey){
		return findbyHqlUnique(sqlkey);
	}
	public  List<Organization> find(String sqlkey){
		return findbyHql(sqlkey);
	}
	@Override
	public List<Organization> findOrderByTime() {
		List<Organization> organizations = findbyHql("from Organization order by time Desc");
		return organizations;
	}
}
