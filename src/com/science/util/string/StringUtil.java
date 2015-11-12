package com.science.util.string;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	/**
	 * 如果字符串对象等于null转换非空""，否则不变
	 * @param str
	 * @return
	 */
	public static String swapNull(String str){
		return str == null?"":str;
	}
	/**
	 * 判断字符串是否为空（包含空对象和空字符串）
	 * @param str 传入字符串
	 * @return 是否为空
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str)){
			return true;
		}
		return false;
	}
	
	/**
	 * 将制定字符串的_字母转换成大写字母(先转成小写字母)
	 * @param str 字符串
	 * @return
	 */
	public static String changeLineToLarge(String str){
		str = str.toLowerCase();
		//匹配_加小写字母
		Pattern pattern = Pattern.compile("_[a-z]");
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			String suitStr = matcher.group();
			str = str.replace(suitStr, suitStr.toUpperCase());
		}
		str = str.replace("_", "");
		return str;
	}
	
	/**
	 * 将制定字符串的大写字母转换成_字母
	 * @param str 字符串
	 * @return
	 */
	public static String changeLargeToLine(String str){
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<str.length();i++){
			String s = str.substring(i, i+1);
			s = s.replaceAll("[A-Z]", "_"+s);
			buffer.append(s);
		}
		return buffer.toString();
	}
	
	/**
	 * 将传入参数首字母变成大写,并加上set返回
	 * @param parameterName 属性名
	 * @return
	 */
	public static String getSetMethodName(String parameterName){
		return "set"+parameterName.substring(0, 1).toUpperCase()+parameterName.substring(1, parameterName.length());
	}
	
	/**
	 * 将传入参数首字母变成大写,并加上get返回
	 * @param parameterName 属性名
	 * @return
	 */
	public static String getGetMethodName(String parameterName){
		return "get"+firstCharToUpper(parameterName);
	}
	
	public static String firstCharToUpper(String str){
		return str.substring(0, 1).toUpperCase()+str.substring(1, str.length());
	}
	public static String firstCharToLower(String str){
		return str.substring(0, 1).toLowerCase()+str.substring(1, str.length());
	}
	/**
	 * 改变字符串编码(from iso-8859-1 to utf-8)
	 * @param initStr
	 * @return
	 */
	public static String convertCodeToUtf(String initStr){
		String result = null;
		try {
			result = new String(initStr.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String[] getImgs(String htmlContent){
		String img = "";
		Pattern p_image;
		Matcher m_image;
		String str = "";
		String[] images = null;
		
		String regEx_img ="(<img.*src\\s*=\\s*(.*?)[^>]*?>)";
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlContent);
		
		while(m_image.find()){
			img = m_image.group();
			System.out.println("====>>"+img);
			Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
			while(m.find()){
				String tempSelected = m.group(1);
				if("".equals(str)){
					str = tempSelected;
				}else{
					String temp = tempSelected;
					str = str +","+ temp;
				}
			}
		}
		if (!"".equals(str)) {
			images = str.split(",");
		}
		return images;
	}
	/*public static void main(String[] args){
		String htmlContent = "<p><img src=\"/scienceBase/ueditor/jsp/upload/image/20151109/1447072626105000494.jpg\" title=\"1447072626105000494.jpg\" alt=\"medf.jpg\"/>请输入内容<a><img src=\"/scienceBase/ueditor/jsp/upload/image/20151109/1447072626105000494.jpg\" title=\"1447072626105000494.jpg\" alt=\"medf.jpg\"/></a></p>";
		String[] imgs = getImgs(htmlContent);
		for(int i = 0;i < imgs.length; i++){
			System.out.println(imgs[i]);
		}
	}*/
	public static String filterScienceBase(String path){
		String result = null;
		String[] str = path.split("/scienceBase");
		result = str[1];
		return result;
	}
}
