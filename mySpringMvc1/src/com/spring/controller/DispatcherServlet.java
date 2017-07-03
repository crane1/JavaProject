package com.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.model.bean.UserInfo;

public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String action = req.getRequestURI();
		action = action.substring(action.lastIndexOf("/") + 1);
		
		System.out.println("action :" + action);
		
		if(action.equals("login.action")){
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			if(id == null || id.equals("") || pwd == null || pwd.equals("")){
				req.setAttribute("mesg", "用户名和密码不能为空");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}else{
				if(id.equals("admin") && pwd.equals("admin")){
					UserInfo user = new UserInfo("admin","admin");
					List<UserInfo> list = getUserList();
					req.setAttribute("userList", list);
					req.getSession().setAttribute("userInfo", user);
					req.getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
				}else{
					req.setAttribute("mesg", "用户名或密码错误");
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				}
			}
		}else if(action.equals("getUserInfo.action")){
			UserInfo user = (UserInfo)req.getSession().getAttribute("userInfo");
			if(user != null){
				List<UserInfo> list = getUserList();
				req.setAttribute("userList", list);
				req.getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
			}else{
				req.setAttribute("mesg", "非法登入");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}
		
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
