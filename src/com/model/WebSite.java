package com.model;

import com.controller.MainController;


public class WebSite {
	public static String browse(String s)
	   {
		   if(s.contains("www") || s.contains("com")){
			   
				s="https://"+s;
				MainController.w=3;
				
			}
		   return s;
	   }
}
