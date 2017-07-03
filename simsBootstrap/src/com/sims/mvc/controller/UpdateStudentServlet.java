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
		//设置解码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String path = request.getContextPath();
		//取得数据库数据
		String action=request.getParameter("action");
		PrintWriter out=response.getWriter();
		if(action==null){
			out.write("请求指令不正确，请返回上一层进行处理");
			return;
		}
		
		if(request.getSession().getAttribute("userinfo")==null){
			out.write("您还没有登录，请重新登录！");
		}
		
		System.out.println("22222");
		//学员进行信息修改
		
		if(action.equals("stu_modify")){
			
		//请求数据取得
			String id=request.getParameter("stuid");
			String name =request.getParameter("stuname");
			String sex=request.getParameter("stusex");
			sex=sex.equals("0")?"男":"女";
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
			
			//修改数据
			int res = stuService.modifyStudent(stu);
			if(res==1){
				request.getSession().setAttribute("stuInfo", stu);
				request.setAttribute("mesg", "个人信息展示");   // 设置什么完成了的提示
				request.setAttribute("linkTitle", "个人信息修改");  // 是指要跳转的页面名称提示
				request.setAttribute("link", path + "/content/student/updateStuInfo.jsp");  // 要跳转的链接地址url
				request.getRequestDispatcher("succeed.jsp").forward(request, response);
			}
		}
	   }
	}
