package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.tools.JsonMesg;
import com.tools.PageManager;

@WebServlet("/ShowEmployeeServlet")
public class ShowEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    @Override
	public void destroy() {
    	System.out.println("destroy");
		super.destroy();
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init");
		super.init();
	}
	public ShowEmployeeServlet() {
    	System.out.println("construct");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String page = request.getParameter("page");
		PageManager.setFindPage(page);
		
		EmployeeFindDAOImp empfind = new EmployeeFindDAOImp();
		List<Employee> list= empfind.findEmployeeByTeamID();
		String result = JsonMesg.getJsonArray(list);
		PrintWriter out = response.getWriter();
		out.write(result);
	}

}
