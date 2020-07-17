package com.model;

import java.text.SimpleDateFormat;  
import java.util.Date;

import com.controller.MainController;

public class DateTime {
	public static String CurrentDateTime(String s)
	{
		String s1=new String();
		String []parts;
		if(s.contains("date") || s.contains("time"))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();
		    s1=formatter.format(date);
		    
		    parts=s1.split(" ");
		    
		    s1="Date: "+parts[0]+" And Current Time: "+parts[1];
			
		    MainController.w=5;
		}
		
		return s1;
	}

}
