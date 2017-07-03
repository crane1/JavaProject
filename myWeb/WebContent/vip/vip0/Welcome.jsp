<%@page import="com.model.UserInfo"%>
<%@page import="java.util.Map"%>
<%@page import="com.manager.ApplicationContains"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
UserInfo user = (UserInfo)session.getAttribute("user");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
<link rel="stylesheet" href="<%=path %>/css/bg.css" />
<link rel="stylesheet" href="<%=path %>/css/all_text.css" />
<link rel="stylesheet" href="<%=path %>/css/welcome.css" />
</head>
<body>
	<div id="layer1">
		<img src="<%=path %>/img/bg.jpg" width="100%" height="100%" />
	</div>
	<div id="outer">
	<div id="main">
		<div id="user_list">
			<%
			out.write("<div class='box'>在线("+ApplicationContains.curUserCNT + ")</div>");
			out.write("<hr/>");
				Map<String, HttpSession> sessionList = ApplicationContains.userMap;
				
				if(sessionList != null && sessionList.size() > 0){
					String user_pic = user.getProtrait();
					if(user_pic == null){
						user_pic = path +"/img/pic1.jpg";
					}
					out.write("<div class='box'><img src='" + user_pic +"' class='pic'>&nbsp;" + user.getName() + "(我)</div>");
					out.write("<hr/>");
					Set<String> keys = sessionList.keySet();
					for(String k : keys){
						HttpSession s = sessionList.get(k);
						UserInfo u = (UserInfo)s.getAttribute("user");
						if(u != null){
							if(user.getId() != u.getId()){
								String pic = u.getProtrait();
								if(pic == null){
									pic = path +"/img/pic1.jpg";
								}
								out.write("<div class='box'><img src='" + pic +"' class='pic'>&nbsp;" + u.getName() + "</div>");
								out.write("<hr/>");
							}
						}
					}
				}
				
			%>
		</div>
		<div id="right">
			<h4>欢迎来到小白的一生，开启你的奇幻之旅吧</h4>
			<p id="loginout"><a href="<%=path %>/LoginOut.jsp" >注销</a>&nbsp;<a href="upload.jsp" >上传头像</a></p>
			<hr/>
			<p><%=user.getName() %>,您是<%=session.getAttribute("qx_name") %>会员！！！ </p>
		</div>
	</div>
	</div>
</body>
</html>