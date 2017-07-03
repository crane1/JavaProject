<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.MessageInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String username = request.getParameter("username");
	String content = request.getParameter("content");
	
	if(title == null || username == null || content == null || title.equals("") ||username.equals("") || content.equals("")){
		response.sendRedirect("setMessage.jsp?erro=input not empty");
		return;
	}
	
	MessageInfo mes = new MessageInfo(title, username, content, new Date());
	request.setAttribute("info", addMessage(mes));
	request.getRequestDispatcher("setMessage.jsp").forward(request, response);
%>

<%!
	public synchronized String addMessage(MessageInfo mes){
		String info = "消息未发送";
		ServletContext app = getServletContext();
		List<MessageInfo> list = (List<MessageInfo>)app.getAttribute("Message");
		
		if(list == null){
			list = new ArrayList<MessageInfo>();
		}
		
		list.add(mes);
		app.setAttribute("Message", list);
		info = "消息已发送";
		return info;
	}
%>