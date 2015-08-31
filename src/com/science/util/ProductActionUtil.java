package com.science.util;




public class ProductActionUtil {
	
	public static void main(String[] args) {
		String className = "Magsysinfo";
		String jspPath = "/admin/addMag_admin.jsp";
		System.out.println(productAddObject(className, jspPath));
	}
	
	public static StringBuffer productAddObject(String className,String jspPath){
		String firstStr = className.substring(0, 1).toLowerCase();
		String restStr = className.substring(1, className.length());
		String objName = new StringBuffer(firstStr).append(restStr).toString();
		StringBuffer buffer =  new StringBuffer();
		buffer.append(appendLn("@Action(value = \"add"+className+"\","));
		buffer.append(appendLn("results = {"));
		String successJspStr = "@Result(name = \"success\", type = \"dispatcher\", location = \""
				+jspPath+"\",";
		buffer.append(appendLn(successJspStr));
		buffer.append(appendLn("params = {}),"));
		buffer.append(appendLn("@Result(name=\"error\",type=\"dispatcher\",location = \"/jsp/error.jsp\","));
		buffer.append(appendLn("params = {\"msg\",\"${msg}\"})})"));
		String methodName = "public String add" + className + "(){";
		buffer.append(appendLn(methodName));
		buffer.append(appendLn("try {"));
		String methodCon = objName + "Manager.save(" + objName + ");";
		buffer.append(appendLn(methodCon));
		buffer.append(appendLn("return SUCCESS;"));
		buffer.append(appendLn("} catch (Exception e) {"));
		buffer.append(appendLn("return ERROR;"));
		buffer.append(appendLn("}"));
		buffer.append(appendLn("}"));
		return buffer;
	}
	
	
	public static StringBuffer appendLn(String appendStr){
		StringBuffer buffer = new StringBuffer();
		buffer.append(appendStr + "\r\n");
		return buffer;
	}
}
