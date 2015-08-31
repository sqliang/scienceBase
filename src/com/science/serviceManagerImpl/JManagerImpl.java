package com.science.serviceManagerImpl;

import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.science.dao.Jdao;
import com.science.serviceManager.JManager;

@Component("jManagerImpl")
public class JManagerImpl implements JManager {
	@Autowired
	private Jdao jdao;
	@Override
	public JSONObject getGridJsonObject(String sql, Serializable... values) {
		JSONObject jsonObject = jdao.getGridJsonObject(sql, values);
		return jsonObject;
	}
	public JSONObject getGridJsonObjectAndPage(String sql, int start, int limit, Serializable... values){
		JSONObject jsonObject = jdao.getGridJsonObjectAndPage(sql, start, limit, values);
		return jsonObject;
	}
	public int getPageCountBySql(String sql, Serializable... values){
		return jdao.getPageCountBySql(sql, values);
	}
	public JSONArray getJsonArray(String sql, Serializable... values) {
		JSONArray array = jdao.getResultJsonArray(sql, values);
		return array;
	}

	@Override
	public String simpleSQL(String sql,Serializable... values) {
		return jdao.simpleSQL(sql,values);
	}

	@Override
	public List<String> simpleSQLAsList(String sql,Serializable... values) {
		return jdao.simpleSQLAsList(sql,values);
	}
	
	@Override
	public JSONObject getJSONObject(String sql, Serializable... values) {
		return jdao.getJSONObject(sql, values);
	}
	@Override
	public long saveAndGetId(Serializable value) {
		
		return jdao.saveAndGetId(value);
	}

}
