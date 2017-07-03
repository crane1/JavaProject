<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
	
	out.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
%>