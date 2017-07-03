package com.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.model.bean.UserInfo;

public class LoginController implements IhandleMapping{

	@Override
	public String handleMapping(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String result = "index.jsp";
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if(id == null || id.equals("") || pwd == null || pwd.equals("")){
			req.setAttribute("mesg", "用户名和密码不能为空");
		}else{
			if(id.equals("admin") && pwd.equals("admin")){
				UserInfo user = new UserInfo("admin","admin");
				List<UserInfo> list = getUserList();
				req.setAttribute("userList", list);
				req.getSession().setAttribute("userInfo", user);
				result = "/WEB-INF/success.jsp";
			}else{
				req.setAttribute("mesg", "用户名或密码错误");
			}
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
