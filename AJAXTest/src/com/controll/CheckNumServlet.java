package com.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckNumServlet
 */
@WebServlet("/CheckNumServlet")
public class CheckNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckNumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String rand = request.getParameter("rand");
		PrintWriter out = response.getWriter();
		if(rand == null || rand.equals("")){
			out.write("0");
			return;
		}
		String randomNum = (String)request.getSession().getAttribute("randomNum");
		System.out.println("-----------------randomNum" + randomNum);
		if(randomNum == null || randomNum.equals("")){
			out.write("1");
			return;
		}
		if(randomNum.equals(rand)){
			out.write("2");
		}else{
			out.write("3");
		}
	}

}
