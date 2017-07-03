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
				out.write("[{\"mesg\":\"��������\"}]");
				return;
			}
		}else if(oper.equals("add")){
			String id = request.getParameter("id");
			stuService = new StudentServiceImp();
			Student stu = stuService.findStudentById(id);
			
			//��ӵ��˲�����
			if(stu == null){
				out.write("��ӵ�id�����ڣ�����");
				return;
			}
			
			//��ӵ����Ѿ��ǹ���Ա��
			if(stu.getNormal_manager() == 1){
				out.write("�Ѿ��ǹ���Ա�ˣ������ظ���ӣ�����");
				return;
			}
			
			//���ô�idΪ����Ա
			stu.setNormal_manager(1);
			int res = stuService.modifyStudent(stu);
			if(res == 1){
				out.write("id:" + id + ",�Ѿ����Ϊ����Ա");
			}
		}else if(oper.equals("del")){
			String id = request.getParameter("id");
			stuService = new StudentServiceImp();
			Student stu = stuService.findStudentById(id);
			
			//������˲�����
			if(stu == null){
				out.write("�����id�����ڣ�����");
				return;
			}
			
			//������˲��ǹ���Ա
			if(stu.getNormal_manager() != 1){
				out.write("��id���ǹ���Աid�����ܰ��⣡����");
				return;
			}
			
			//�����id����Ա
			stu.setNormal_manager(0);
			int res = stuService.modifyStudent(stu);
			if(res == 1){
				out.write("id:" + id + ",�Ѿ�������");
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
		str = str.substring(0, str.length()-1); //�ص����һ������
		str += "]";
		System.out.println(str);
		return str;
	}

}
