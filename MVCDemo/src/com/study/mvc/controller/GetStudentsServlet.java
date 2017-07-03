package com.study.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.mvc.model.bean.Student;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;

@WebServlet("/GetStudentsServlet")
public class GetStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetStudentsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService stuService = new StudentServiceImp();
		List<Student> list = stuService.findAll();
		request.getRequestDispatcher("welcomeJson.jsp").forward(request, response);
	}

}
