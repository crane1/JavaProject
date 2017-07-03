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
		// 0 ����������
		String id = null;  //���մ��ݹ�����ѧ��
		String pwd = null;  //��������
		
		// 1 ���ñ���
		
		PrintWriter out = response.getWriter();
		
		// 2 ���ձ���
		id = request.getParameter("id"); 
		pwd = request.getParameter("pwd");
		
		System.out.println("--------------id:" + id);
		System.out.println("--------------pwd:" + pwd);
		// 3.1��֤�Ϸ���
		if(id == null || pwd == null || id.equals("") || pwd.equals("")){
			String data = "�û��������벻��Ϊ��";
			out.write(data);
			return;
		}
		
		// 3.2 ��֤��ȷ��
		
		ILoginCheckService checkService= new LoginCheckServiceImp();//
		Student user = checkService.checkLoginUser(id, pwd);
		
		if(user != null){
			request.getSession().setAttribute("user", user);
			String data = "��¼�ɹ�";
			out.write(data);
			return;
		}else{
			String data = "�û��������벻��ȷ";
			out.write(data);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
