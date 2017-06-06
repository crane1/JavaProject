package com.study.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.mvc.model.bean.Student;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;

@WebServlet("/ModifyStuServlet")
public class ModifyStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyStuServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		id = new String(id.getBytes("ISO-8859-1"),"UTF-8");
		
		IStudentService stuService = new StudentServiceImp();
		Student stu = stuService.findStuById(id);
		
		if(stu != null){
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("modifyStu.jsp").forward(request, response);
		}else{
			request.setAttribute("mes", "修改的学生信息不存在");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
	}

}
