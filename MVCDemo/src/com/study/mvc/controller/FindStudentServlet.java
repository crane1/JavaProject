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
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;

@WebServlet("/FindStudentServlet")
public class FindStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		PrintWriter out = response.getWriter();
		System.out.println("condition:" + condition );
		
		if(condition != null){
			IStudentService stuService = new StudentServiceImp();
			if(condition.equals("name")){
				String name = request.getParameter("name");
				System.out.println("name:"+name);
				if(name != null){
					List<Student> names = stuService.findStusByName(name);
					if(names != null){
						String str = writeList(names);
						out.write(str);
					}else{
						out.write("ÔÝÎÞÊý¾Ý");
					}
					
				}
			}
		}
		
	}
	
	private String writeList(List<Student> list){
		String str = "";
		str += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		str += "<students>";
		for(Student stu : list){
			str += "<student>" 
					+ stu.getS_id() + "#"
					+ stu.getS_name() + "#"
					+ stu.getS_age() + "#"
					+ stu.getS_sex() + "#"
					+ stu.getS_gradInst()
					+ "</student>";
		}
		str += "</students>";
		return str;
	}
}
