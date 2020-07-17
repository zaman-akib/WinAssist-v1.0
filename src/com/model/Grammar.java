package com.model;

import com.controller.MainController;

public class Grammar {
	public static String chat(String s) {

		String s1 = new String();

		if (s.contains("hi") || s.contains("hello")) {

			if (s.contains("bro")) {
				s1 = "Hello bro!";
				MainController.w = 1;
			} else

			{
				s1 = "Hello there!";
				MainController.w = 1;
			}
		} else if (s.contains("how are you")) {
			int decider = (int) (Math.random() * 2 + 1);
			if (decider == 1) {
				s1 = "Alhamdulillah. What about you?";
				MainController.w = 1;
			} else if (decider == 2) {
				s1 = "Alhamdulillah. I am fine. What about you?";
				MainController.w = 1;
			}
		} else if (s.contains("joke")) {
			s1 = "What’s the difference between Windows 95 and a virus? A virus does something.";
			MainController.w = 1;
		} else if ((s.contains("thanks")) || (s.contains("thank you"))) {
			s1 = "it's my pleasure.";
			MainController.w = 1;
		} else if (s.contains("help")) {
			s1 = "In sha Allah I will try.";
			MainController.w = 1;
		} else if (s.contains("ok")) {
			s1 = "Thank you sir.";
			MainController.w = 1;
		} else if (s.contains("who are you")) {
			s1 = "I am your Personal Assistant.I am here to help you.";
			MainController.w = 1;
		} else if (s.contains("can you")) {
			s1 = "I will try.";
			MainController.w = 1;
		} else if ((s.contains("Assalamualaikum")) || (s.contains("salam"))) {
			s1 = "Walaikumassalam.";
			MainController.w = 1;
		} else if ((s.contains("morning")) || (s.contains("night")) || (s.contains("evening"))) {
			s1 = s;
			MainController.w = 1;
		} else if ((s.contains("fine")) || (s.contains("i am ok")) || (s.contains("i am alright"))
				|| (s.contains("fantastic"))) {
			s1 = "Great!!";
			MainController.w = 1;
		} else if ((s.contains("not fine")) || (s.contains("bad")) || (s.contains("sad"))) {
			s1 = "Don't worry everything will be ok.";
			MainController.w = 1;
		} else if (s.contains("exit") || s.contains("stop") || s.contains("tata") || s.contains("bye")
				|| s.contains("close")) {
			System.exit(0);
		} else if (s.contains("What is your name?")) {
			int decider = (int) (Math.random() * 2 + 1);
			if (decider == 1) {
				s1 = "Arrya.";
				MainController.w = 1;
			} else if (decider == 2) {
				s1 = "Why?";
				MainController.w = 1;
			}
		} else if (s.contains("Who am i?")) {

			s1 = "You are my Boss";
			MainController.w = 1;
		} else if (s.contains("sing a song")) {

			s1 = "Tujhe dekha to ye jana sanam Pyar hota hain dewana sanam";
			MainController.w = 1;
		} else if (s.contains("sing another song")) {

			s1 = "You just want attention, you don't want my heart\r\n"
					+ "Maybe you just hate the thought of me with someone new\r\n"
					+ "Yeah, you just want attention, I knew from the start\r\n"
					+ "You're just making sure I'm never gettin' over you";
			MainController.w = 1;
		} else if (s.contains("mist")) {

			s1 = "Military institute of science and technology";
			MainController.w = 1;
		} else if (s.contains("why sorry")) {

			s1 = "because i couldn't give you your answer sir";
			MainController.w = 1;
		} else if (s.contains("how old are you") || s.contains("age")) {

			s1 = "sorry it's personal";
			MainController.w = 1;
		} else if (s.contains("married") || s.contains("boyfriend")) {

			s1 = "I am single";
			MainController.w = 1;
		} else if (s.contains("i love you")) {

			s1 = "I love you too";
			MainController.w = 1;
		} else if (s.contains("Can you learn new")) {

			s1 = "I'm still learning";
			MainController.w = 1;
		} else if (s.contains("speak in bangla")) {

			s1 = "kemon acho? valo acho?";
			MainController.w = 1;
		} else if (s.contains("valo achi")) {

			s1 = "Amio valo achi";
			MainController.w = 1;
		} else if (s.contains("play a song")) {

			s1 = "Please write on above youtube bar sir!";
			MainController.w = 1;
		} else if (s.contains("stupid") || s.contains("nonsense")) {

			s1 = "Please don't use bad words!";
			MainController.w = 1;
		} else if (s.contains("what you can't do")) {

			s1 = "i can do only a few things i'm still learning";
			MainController.w = 1;
		} else if (s.contains("java")) {

			s1 = "programing language";
			MainController.w = 1;
		} else if (s.contains("Happy birthday")) {

			s1 = "sorry today is not my birthday";
			MainController.w = 1;
		} else if (s.contains("send a email")) {

			s1 = "sir please you need to login on gmail and can send email.you can search email on google search bar";
			MainController.w = 1;
		} else if (s.contains("cse")) {

			s1 = "computer science and engineering";
			MainController.w = 1;
		} else if (s.contains("cse dept head of mist")) {

			s1 = "Air cmdt Afzal sir";
			MainController.w = 1;
		} else if (s.contains("java course teacher")) {

			s1 = "lt cdr Arnab pal sir,Captain Naim sir,Lec Anik sir and Lec Antu sir";
			MainController.w = 1;
		} else if (s.contains("sad")) {

			s1 = "please don't be sad!! everything will be alright";
			MainController.w = 1;
		} else if (s.contains("wow")) {

			s1 = "thank you sir";
			MainController.w = 1;
		} else if (s.contains("nice")) {

			s1 = "thank you sir";
			MainController.w = 1;
		} else if (s.contains("very nice")) {

			s1 = "thank you sir";
			MainController.w = 1;
		} else if (s.contains("wonderful")) {

			s1 = "thank you sir";
			MainController.w = 1;
		} else if (s.contains("funny")) {

			s1 = "thank you sir";
			MainController.w = 1;
		} else if (s.contains("not good") || s.contains("bad")) {

			s1 = "sorry sir";
			MainController.w = 1;
		} else if (s.contains("dance")) {

			s1 = "sorry sir i can't";
			MainController.w = 1;
		} else if (s.contains("artificial intelligence")) {

			s1 = "Artificial intelligence (AI) is an area of computer science that emphasizes the creation of intelligent machines that work and react like humans. Some of the activities computers with artificial intelligence are designed for include: Speech recognition.";
			MainController.w = 1;
		} else if (s.contains("hi alexa") || s.contains("hi Alexa") || s.contains("Alexa") || s.contains("alexa")) {

			s1 = "Yes Sir";
			MainController.w = 1;
		}
		return s1;
	}
}
