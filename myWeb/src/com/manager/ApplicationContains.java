package com.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class ApplicationContains {
	public static int curUserCNT = 0; //当前用户数
	public static Map<String,HttpSession> userMap = new HashMap<String,HttpSession>(); //sessionSet
	
}
