package com.science.serviceManager;


import com.science.domain.Organization;
import java.util.List;

public interface OrganizationManager extends BaseManager<Organization> {


	public void addOrganization(Organization organization);

	public void addOrganizations(List<Organization> organizations);

	public Organization load(String sqlkey);

	public List<Organization> find(String sqlkey);
	
	public List<Organization> findOrderByTime();

}
