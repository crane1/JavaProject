package com.sims.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NumServlet
 */
@WebServlet("/NumServlet")
public class NumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String randNum=request.getParameter("randNum");	  
		String rand=(String) request.getSession().getAttribute("rand");
		   PrintWriter out = response.getWriter();
		  System.out.println("==randNum=="+randNum);  
		  System.out.println("==rand=="+rand);
		if(randNum==null||randNum.equals("")||rand==null||rand.equals("")){
			out.write("NULL");
		}else if(randNum.equals(rand)){
				out.write("OK");
			}else{
				out.write("NG");
			}
		}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doGet(request, response);
	}

}
