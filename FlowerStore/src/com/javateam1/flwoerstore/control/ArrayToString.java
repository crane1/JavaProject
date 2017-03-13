package com.javateam1.flwoerstore.control;

public class ArrayToString {
	public static String arrayToString(String[] s){
		StringBuffer str = new StringBuffer("");
		for (String s1 : s){
			str.append(s1+",");
		}
		return str.toString();
	}
}
