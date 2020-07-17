package com.model;

import java.io.IOException;

import com.controller.MainController;

public class DesktopTask {
	
	public static String run(String s)
	   {
		   String s1=new String();
		   
		   if(s.contains("run") || s.contains("open")){
			    String string =s ;
				String[] parts = string.split("\\>>");
				
				MainController.w=4;
					 try {
						 String s2="cmd /c start "+parts[1];
							Runtime.getRuntime().exec(s2);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		   
		   return s1;
	   }

}

