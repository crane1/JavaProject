package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.DBUtil;
import com.model.UserInfo;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		
		if(id == null || id.equals("")){
			response.sendRedirect("register.jsp?error=id_empty");
			return;
		}
		
		DBUtil dbUtil =  DBUtil.getInstance();
		UserInfo user = dbUtil.queryUserById(id);
		
		if(user != null){
			response.sendRedirect("register.jsp?error=id_has");
			return;
		}
		
		if(pwd == null || pwd.equals("")){
			response.sendRedirect("register.jsp?error=pwd_empty");
			return;
		}
		if(name == null || name.equals("")){
			name = "Ð¡°×";
		}
		
		UserInfo insertUser = new UserInfo(id,name,pwd,0);
		boolean result = dbUtil.addUser(insertUser);
		
		if(result){
			response.sendRedirect("Login.jsp?mes=succeed_reg");
		}else{
			response.sendRedirect("register.jsp?error=add_fail");
		}
		
	}

}
