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

@WebServlet("/FindStuServlet")
public class FindStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindStuServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String sAge = request.getParameter("startAge");
		String eAge = request.getParameter("endAge");
		if(sAge.equals("")){
			sAge = "0";
		}
		if(eAge.equals("")){
			eAge = "0";
		}
		int startAge = Integer.parseInt(sAge);
		int endAge = Integer.parseInt(eAge);
		String gradInst = request.getParameter("gradInst");
		
		System.out.println("id:" +id +" name:" + name +" sex:" +sex + " startAge:" + startAge + " endAge:" + endAge +" gradInst:"+ gradInst);
		
		IStudentService stuService = new StudentServiceImp();
		
		List<Student> list = stuService.findStusByCondition(id, name, sex, startAge, endAge, gradInst);
		
		request.getSession().setAttribute("userlist", list);
		
		response.sendRedirect("welcome.jsp");
	}

}
