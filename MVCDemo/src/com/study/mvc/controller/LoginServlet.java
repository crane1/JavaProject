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
		// 0 ����������
		String id = null;  //���մ��ݹ�����ѧ��
		String pwd = null;  //��������
		
		// 1 ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2 ���ձ���
		id = request.getParameter("id"); 
		pwd = request.getParameter("pwd");
		
		// 3.1��֤�Ϸ���
		if(id == null || pwd == null || id.equals("") || pwd.equals("")){
			request.setAttribute("erro", "�û��������벻��Ϊ��");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		
		// 3.2 ��֤��ȷ��
		
		ILoginCheckService checkService= new LoginCheckServiceImp();
		Student user = checkService.checkLoginUser(id, pwd);
		
		if(user != null){
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else{
			request.setAttribute("erro", "�û��������벻��ȷ");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
