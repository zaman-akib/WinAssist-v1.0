package com.model;

import com.controller.MainController;

public class GoogleSearch {
	public static String search(String s) {
		String[] parts;
		String url = new String();
		if ((s.contains("google") || s.contains("youtube")) && !s.contains("com")) {
			parts = s.split("\\>>");

			String searchedItem = parts[1].replaceAll(" ", "+");
			if (s.contains("youtube")) {
				url = "https://www.youtube.com/results?search_query=" + searchedItem;
			} else {
				url = "https://www.google.com/search?q=" + searchedItem;
			}

			MainController.w = 6;
		}
		return url;
	}

}
