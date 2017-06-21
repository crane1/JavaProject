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
			request.setAttribute("mesg", "���벻��Ϊ��");
			request.getRequestDispatcher("/content/student/mod_pwd.jsp").forward(request, response);
			return;
		}
		
		if(!new_pwd.equals(con_pwd)){
			request.setAttribute("mesg", "�����������벻һ��");
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
				request.setAttribute("mesg", "�����޸�");   // ����ʲô����˵���ʾ
				request.setAttribute("linkTitle", "�����޸�");  // ��ָҪ��ת��ҳ��������ʾ
				request.setAttribute("link", path + "/content/student/mod_pwd.jsp");  // Ҫ��ת�����ӵ�ַurl
				request.getRequestDispatcher("succeed.jsp").forward(request, response);
			}else{
				request.setAttribute("mesg", "��Ǹ����̨������");
				request.getRequestDispatcher("/content/student/mod_pwd.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("mesg", "ԭ�������");
			request.getRequestDispatcher("/content/student/mod_pwd.jsp").forward(request, response);
			return;
		}
	}
}
