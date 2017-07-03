package com.study.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.mvc.model.bean.Student;
import com.study.mvc.model.service.ILoginCheckService;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.LoginCheckServiceImp;
import com.study.mvc.model.service.StudentServiceImp;

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
		
		PrintWriter out = response.getWriter();
		
		// 2 接收变量
		id = request.getParameter("id"); 
		pwd = request.getParameter("pwd");
		
		System.out.println("--------------id:" + id);
		System.out.println("--------------pwd:" + pwd);
		// 3.1验证合法性
		if(id == null || pwd == null || id.equals("") || pwd.equals("")){
			String data = "用户名或密码不能为空";
			out.write(data);
			return;
		}
		
		// 3.2 验证正确性
		
		ILoginCheckService checkService= new LoginCheckServiceImp();//
		Student user = checkService.checkLoginUser(id, pwd);
		
		if(user != null){
			request.getSession().setAttribute("user", user);
			String data = "登录成功";
			out.write(data);
			return;
		}else{
			String data = "用户名或密码不正确";
			out.write(data);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
