package com.lizm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizm.beans.Message;
import com.lizm.service.MessageService;

@SuppressWarnings("serial")
public class ALinkServlet extends HttpServlet {
	
	MessageService messageService = new MessageService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String page = req.getParameter("page");
		if(page != null && !"".equals(page)){
			if(page.equals("insert")){
				//如果是新增信息，则直接跳转到添加页面
				req.getRequestDispatcher("/WEB-INF/jsp/back/insert.jsp").forward(req, resp);
			} else if(page.equals("update")){
				//如果是更新信息，则需要把messag参数传到添加页面（更新页面）
				String id = req.getParameter("id");
				
				Message message = messageService.queryMesgById(id);
				
				if(message != null){
					req.setAttribute("message", message);
					req.getRequestDispatcher("/WEB-INF/jsp/back/insert.jsp").forward(req, resp);
				}else{
					out.write("修改的数据不存在");
					return;
				}
			}
		}
	}

}
