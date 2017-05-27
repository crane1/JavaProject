<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
out.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
%>