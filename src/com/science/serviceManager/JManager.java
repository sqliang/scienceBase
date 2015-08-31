package com.science.serviceManager;

import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface JManager {
	public JSONObject getGridJsonObjectAndPage(String sql, int start, int limit, Serializable... values);
	
	/**
	 * 查询sql语句对应返回结果json数组形式
	 * @param sql sql语句
	 * @param values 注入value值
	 * @return
	 */
	public JSONArray getJsonArray(String sql, Serializable... values);

	/**
	 * 查询sql语句，返回第一行第一列的值（String形式）
	 * @param sql sql语句
	 * @param values 注入值
	 * @return
	 */
	public String simpleSQL(String s3,Serializable... values);

	public JSONObject getJSONObject(String sql, Serializable... values);
	public int getPageCountBySql(String sql, Serializable... values);
	
	/**
	 * 查询sql语句，返回第一列的值（List<String>形式）
	 * @param sql sql语句
	 * @param values 注入值
	 * @return
	 */
	public List<String> simpleSQLAsList(String sql, Serializable... values);

	public JSONObject getGridJsonObject(String sql, Serializable... values);
	
	public long saveAndGetId(Serializable value);
}
