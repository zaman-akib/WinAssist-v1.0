package com.model;
import java.io.*;

import java.util.Scanner;

import com.controller.MainController;

public class Reminder {
	
	public static String remind(String s){
		
	String s1=new String();
	if(s.contains("remember") || s.contains("save") || (s.contains("remind") && !s.contains("reminder"))){
		MainController.w=7;
		String []parts=s.split("\\>>");
	
		File f=new File("Reminder.txt");
		FileWriter fr;
		try {
			fr=new FileWriter(f);
			fr.write(parts[1]);
			fr.flush();
			fr.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		File f1=new File("Reminder.txt");
		
		try {
			Scanner sc=new Scanner(f1);
			while(sc.hasNextLine())
			{
				s1="Reminder saved as: "+sc.nextLine();
			}
			sc.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	 }
	
		if(s.contains("memory") || s.contains("reminder")) {
			MainController.w=7;
			File f1=new File("Reminder.txt");
			try {
				Scanner sc=new Scanner(f1);
				while(sc.hasNextLine())
				{
					s1="Reminder: "+sc.nextLine();
					
				}
				sc.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		  return s1;
	   }

}
