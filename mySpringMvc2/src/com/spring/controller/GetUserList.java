package com.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.model.bean.UserInfo;

public class GetUserList implements IhandleMapping {

	@Override
	public String handleMapping(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String result = "index.jsp";
		UserInfo user = (UserInfo)req.getSession().getAttribute("userInfo");
		
		if(user != null){
			List<UserInfo> list = getUserList();
			req.setAttribute("userList", list);
			result = "/WEB-INF/success.jsp";
		}else{
			req.setAttribute("mesg", "∑«∑®µ«»Î");
		}
		
		return result;
	}

	private List<UserInfo> getUserList(){
		List<UserInfo> list = new ArrayList<UserInfo>();
		
		list.add(new UserInfo("admin","admin"));
		list.add(new UserInfo("admin1","admin1"));
		list.add(new UserInfo("admin2","admin2"));
		list.add(new UserInfo("admin3","admin3"));
		list.add(new UserInfo("admin4","admin4"));
		list.add(new UserInfo("admin5","admin5"));
		
		return list;
	}
}
