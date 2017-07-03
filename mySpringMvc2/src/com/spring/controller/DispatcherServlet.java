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
		String result = "index.jsp";
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String action = req.getRequestURI();
		action = action.substring(action.lastIndexOf("/") + 1);
		
		System.out.println("action :" + action);
		
		
		if(action.equals("login.action")){
			LoginController loginController = new LoginController();
			result = loginController.handleMapping(req, resp);
		}else if(action.equals("getUserInfo.action")){
			GetUserList getUserList = new GetUserList();
			result = getUserList.handleMapping(req, resp);
		}
		req.getRequestDispatcher(result).forward(req, resp);
	}
}
