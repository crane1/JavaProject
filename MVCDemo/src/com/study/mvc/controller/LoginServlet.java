package com.study.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.mvc.model.bean.Student;
import com.study.mvc.model.service.ILoginCheckService;
import com.study.mvc.model.service.LoginCheckServiceImp;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0 变量定义区
		String id = null;  //接收传递过来的学号
		String pwd = null;  //接收密码
		
		// 1 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2 接收变量
		id = request.getParameter("id"); 
		pwd = request.getParameter("pwd");
		
		// 3.1验证合法性
		if(id == null || pwd == null || id.equals("") || pwd.equals("")){
			request.setAttribute("erro", "用户名或密码不能为空");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		
		// 3.2 验证正确性
		
		ILoginCheckService checkService= new LoginCheckServiceImp();
		Student user = checkService.checkLoginUser(id, pwd);
		
		if(user != null){
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else{
			request.setAttribute("erro", "用户名或密码不正确");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
