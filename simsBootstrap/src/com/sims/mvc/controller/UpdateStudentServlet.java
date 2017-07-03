package com.sims.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.Response;

import com.sims.mvc.model.bean.Student;
import com.sims.mvc.model.dao.StudentFindDAOImp;
import com.sims.mvc.model.service.IStudentService;
import com.sims.mvc.model.service.StudentServiceImp;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ý���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String path = request.getContextPath();
		//ȡ�����ݿ�����
		String action=request.getParameter("action");
		PrintWriter out=response.getWriter();
		if(action==null){
			out.write("����ָ���ȷ���뷵����һ����д���");
			return;
		}
		
		if(request.getSession().getAttribute("userinfo")==null){
			out.write("����û�е�¼�������µ�¼��");
		}
		
		System.out.println("22222");
		//ѧԱ������Ϣ�޸�
		
		if(action.equals("stu_modify")){
			
		//��������ȡ��
			String id=request.getParameter("stuid");
			String name =request.getParameter("stuname");
			String sex=request.getParameter("stusex");
			sex=sex.equals("0")?"��":"Ů";
			String age =request.getParameter("stuage");
			String gradFrom=request.getParameter("stugradFrom");
			String tel=request.getParameter("stutel");
			String addr=request.getParameter("stuaddr");
			String idCard=request.getParameter("stuidCard");
			String email=request.getParameter("stuemail");
			if(id==null||name==null||sex==null||age==null||gradFrom==null
					||tel==null||addr==null||idCard==null||email==null){
				response.sendRedirect(path + "/content/student/showStuInfo.jsp");
				return;
			}
			
			IStudentService stuService = new StudentServiceImp();
			Student stu= stuService.findStudentById(id);
			stu.setName(name);
			stu.setSex(sex);
			stu.setAge(Integer.parseInt(age));
			stu.setAddr(addr);
			stu.setGradFrom(gradFrom);
			stu.setTel(Long.parseLong(tel));
			stu.setIdCard(idCard);
			stu.setEmail(email);
			
			//�޸�����
			int res = stuService.modifyStudent(stu);
			if(res==1){
				request.getSession().setAttribute("stuInfo", stu);
				request.setAttribute("mesg", "������Ϣչʾ");   // ����ʲô����˵���ʾ
				request.setAttribute("linkTitle", "������Ϣ�޸�");  // ��ָҪ��ת��ҳ��������ʾ
				request.setAttribute("link", path + "/content/student/updateStuInfo.jsp");  // Ҫ��ת�����ӵ�ַurl
				request.getRequestDispatcher("succeed.jsp").forward(request, response);
			}
		}
	   }
	}
