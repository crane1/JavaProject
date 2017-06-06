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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentService stuService = new StudentServiceImp();
       
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int mes = 0; //没有更新成功
		
		//更新数据
		if(action.equals("stu_upd")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			int age = Integer.parseInt(request.getParameter("age"));
			String gradInst = request.getParameter("gradInst");
			
			Student stu = new Student(id, name, sex, age, gradInst);
			
			if(stuService.modify(stu) > 0){
				mes = 1;  // 更新成功
			}
		}
		else if(action.equals("stu_del")){
			String id = request.getParameter("id");
			
			if(stuService.delete(id) > 0){
				mes = 1;  // 更新成功
			}
		}
		
		IStudentService stuService = new StudentServiceImp();
		List<Student> list = stuService.findAll();
		request.getSession().setAttribute("userlist", list);
		
		response.sendRedirect("welcome.jsp?mes=" + mes);
		
	}

}
