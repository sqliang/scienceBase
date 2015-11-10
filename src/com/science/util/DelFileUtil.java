package com.science.util;

import java.io.File;

import org.apache.struts2.ServletActionContext;

public class DelFileUtil {
	
	public static void deleteFile(String path){
		
		File file = new File(path);
		if(file.exists()){
			file.delete();
			System.out.println("finished");
		}else {
			System.out.println("error");
		}
	}
	
	/*public static void main(String[] args){
		String url = "/scienceBase/ueditor/jsp/upload/image20151109/1447078965109002381.jpg";
		String path = ServletActionContext.getServletContext().getRealPath(url);
		System.out.println(path);
//		deleteFile(path);
	}*/
}
