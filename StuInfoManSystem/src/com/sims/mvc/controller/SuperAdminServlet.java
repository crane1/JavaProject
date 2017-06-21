package com.sims.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.StudentServiceImp;
import com.sims.mvc.tools.PageManager;

@WebServlet("/SuperAdminServlet")
public class SuperAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuperAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String oper = request.getParameter("oper");
		IStudentService stuService = null;
		
		if(oper.equals("query")){
			String page = request.getParameter("page");
			
			PageManager.setFindPage(page);
			
			stuService = new StudentServiceImp();
			List<Student> list = stuService.findStudentByIsAdmin();
			if(list != null){
				String str = writeList(list);
				out.write(str);
			}else{
				out.write("[{\"mesg\":\"暂无数据\"}]");
				return;
			}
		}else if(oper.equals("add")){
			String id = request.getParameter("id");
			stuService = new StudentServiceImp();
			Student stu = stuService.findStudentById(id);
			
			//添加的人不存在
			if(stu == null){
				out.write("添加的id不存在！！！");
				return;
			}
			
			//添加的人已经是管理员了
			if(stu.getNormal_manager() == 1){
				out.write("已经是管理员了，不用重复添加！！！");
				return;
			}
			
			//设置此id为管理员
			stu.setNormal_manager(1);
			int res = stuService.modifyStudent(stu);
			if(res == 1){
				out.write("id:" + id + ",已经添加为管理员");
			}
		}else if(oper.equals("del")){
			String id = request.getParameter("id");
			stuService = new StudentServiceImp();
			Student stu = stuService.findStudentById(id);
			
			//罢免的人不存在
			if(stu == null){
				out.write("罢免的id不存在！！！");
				return;
			}
			
			//罢免的人不是管理员
			if(stu.getNormal_manager() != 1){
				out.write("该id不是管理员id，不能罢免！！！");
				return;
			}
			
			//罢免此id管理员
			stu.setNormal_manager(0);
			int res = stuService.modifyStudent(stu);
			if(res == 1){
				out.write("id:" + id + ",已经被罢免");
			}
		}
	}
	
	private String writeList(List<Student> list){
		String str = "";
		str += "[";
		for(Student stu : list){
			str += "{"+
					"\"id\":\"" + stu.getId() + "\"," +
					"\"name\":\""+ stu.getName() + "\"," +
					"\"tel\":\""+ stu.getTel() + "\"" +
					"},";
		}
		str = str.substring(0, str.length()-1); //截掉最后一个，号
		str += "]";
		System.out.println(str);
		return str;
	}

}
