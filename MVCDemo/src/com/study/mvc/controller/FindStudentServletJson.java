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
import com.study.mvc.tools.PageManager;

@WebServlet("/FindStudentServletJson")
public class FindStudentServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindStudentServletJson() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		PrintWriter out = response.getWriter();
		System.out.println("condition:" + condition );
		
		String page = request.getParameter("page");
		
		if(page.equals("first")){
			PageManager.setCurPageNo(1);
		}else if(page.equals("pre")){
			PageManager.setCurPageNo(PageManager.getPrePageNo());
		}else if(page.equals("nxt")){
			PageManager.setCurPageNo(PageManager.getNextPageNo());
			System.out.println("cur111:---------" + PageManager.getCurPageNo());
			System.out.println("max111:---------" + PageManager.getMaxPageNo());
		}else if(page.equals("last")){
			PageManager.setCurPageNo(PageManager.getMaxPageNo());
		}else {
			int num = Integer.parseInt(page);
			if(num >= PageManager.getMaxPageNo()){
				PageManager.setCurPageNo(PageManager.getMaxPageNo());
			}else if(num <=1){
				PageManager.setCurPageNo(1);
			}else{
				PageManager.setCurPageNo(num);
			}
			
		}
		
		
		if(condition != null){
			IStudentService stuService = new StudentServiceImp();
			if(condition.equals("name")){
				String name = request.getParameter("name");
				System.out.println("name:"+name);
				if(name != null){
					List<Student> list = stuService.findStusByName(name);
					System.out.println("list:----------" + list);
					if(list != null){
						String str = writeList(list);
						out.write(str);
					}else{
						System.out.println("---------------2");
						out.write("[{\"mesg\":\"暂无数据\"}]");
						return;
					}
				}
			}
		}
		
	}
	
	private String writeList(List<Student> list){
		String str = "";
		str += "[";
		for(Student stu : list){
			str += "{"+
					"\"id\":\"" + stu.getS_id() + "\"," +
					"\"name\":\""+ stu.getS_name() + "\"," +
					"\"age\":\""+ stu.getS_age() + "\"," +
					"\"sex\":\""+ stu.getS_sex() + "\"," +
					"\"gradInst\":\""+ stu.getS_gradInst() + "\"" +
					"},";
		}
		str = str.substring(0, str.length()-1); //截掉最后一个，号
		str += "]";
		System.out.println(str);
		return str;
	}
}
