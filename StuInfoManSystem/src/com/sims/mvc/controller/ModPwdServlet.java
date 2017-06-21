package com.sims.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.service.ILoginService;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.LoginServiceImp;
import com.sims.mvc.model.service.StudentServiceImp;

@WebServlet("/ModPwdServlet")
public class ModPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModPwdServlet() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String old_pwd = request.getParameter("old_pwd");
		String new_pwd = request.getParameter("new_pwd");
		String con_pwd = request.getParameter("con_pwd");
		String path = request.getContextPath();
		
		System.out.println("old_pwd:" + old_pwd);
		System.out.println("new_pwd:" + new_pwd);
		System.out.println("con_pwd:" + con_pwd);
		
		if(old_pwd == null || new_pwd == null || con_pwd == null 
			|| old_pwd.equals("") || new_pwd.equals("") || con_pwd.equals("") ){
			request.setAttribute("mesg", "密码不能为空");
			request.getRequestDispatcher("/content/student/mod_pwd.jsp").forward(request, response);
			return;
		}
		
		if(!new_pwd.equals(con_pwd)){
			request.setAttribute("mesg", "两次输入密码不一致");
			request.getRequestDispatcher("/content/student/mod_pwd.jsp").forward(request, response);
			return;
		}
		
		Student cur_stu = (Student)request.getSession().getAttribute("stuInfo");
		String id = cur_stu.getId();
		ILoginService loginSerivce = new LoginServiceImp();
		Student stu = loginSerivce.checkStuInfo(id, old_pwd);
		
		if(stu != null){
			IStudentService stuService = new StudentServiceImp();
			int res = stuService.modifyStudentPWD(id, new_pwd);
			if(res > 0){
				request.setAttribute("mesg", "密码修改");   // 设置什么完成了的提示
				request.setAttribute("linkTitle", "密码修改");  // 是指要跳转的页面名称提示
				request.setAttribute("link", path + "/content/student/mod_pwd.jsp");  // 要跳转的链接地址url
				request.getRequestDispatcher("succeed.jsp").forward(request, response);
			}else{
				request.setAttribute("mesg", "抱歉，后台出错了");
				request.getRequestDispatcher("/content/student/mod_pwd.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("mesg", "原密码错误");
			request.getRequestDispatcher("/content/student/mod_pwd.jsp").forward(request, response);
			return;
		}
	}
}
