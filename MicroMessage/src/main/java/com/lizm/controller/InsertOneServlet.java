package com.lizm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizm.service.MessageService;

@SuppressWarnings("serial")
public class InsertOneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String commod = req.getParameter("commod");
		String descript = req.getParameter("descript");
		String context = req.getParameter("context");
		
		System.out.println("commod:" + commod);
		int result = new MessageService().InsertOne(commod, descript, context);
		
		String path = req.getContextPath();
		resp.sendRedirect(path + "/List.action");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
