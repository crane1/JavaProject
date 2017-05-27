package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DBUtil;
import com.model.UserInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintStream printStream = null;
	
	{
		
		try {
			printStream = new PrintStream(new FileOutputStream(new File("c:\\systemout.log"), true));
			System.setOut(printStream);
			System.setErr(printStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		UserInfo user = DBUtil.getInstance().queryUser(id, pwd);
		
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
//			session.setMaxInactiveInterval(20);
			
			response.sendRedirect("welcome.jsp");
		}else{
			response.sendRedirect("Fail.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
