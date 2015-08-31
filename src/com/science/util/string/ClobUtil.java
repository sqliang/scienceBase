package com.science.util.string;

import java.io.BufferedReader;
import java.io.Reader;

import oracle.sql.CLOB;

public class ClobUtil {

	public static String ClobToString(CLOB clob){ 
		try{
			String reString = ""; 
			Reader is = clob.getCharacterStream();// 得到流 
			BufferedReader br = new BufferedReader(is); 
			String s = br.readLine(); 
			StringBuffer sb = new StringBuffer(); 
			while (s != null) {// 执行循环将字符串全部取出付值给 StringBuffer由StringBuffer转成STRING 
				sb.append(s); 
				s = br.readLine(); 
			} 
			reString = sb.toString(); 
			return reString; 
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}


}
