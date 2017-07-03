<%@page import="com.study.mvc.model.bean.UserInfo"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>欢迎页面</title>
		<link rel="stylesheet" href="css/bg.css" />
		<link rel="stylesheet" href="css/meg_board.css" />
		<link rel="stylesheet" href="css/welcom.css" />
	</head>
	<body>
	 	<% 
	 	//获取当前用户
		UserInfo cur_user = (UserInfo)session.getAttribute("user");
	 	%>
		<div id="layer1" >
    		<img src="img/bg1.jpg" width="100%" height="100%"/>
    	</div>
    	
    	<div style="text-align: center">
    		<%=cur_user.getName() %><a href="Loginout.jsp">注销</a>
    		<a href="MessageBoard.jsp">留言板</a>
    	</div><br><br>
    	
    	<div id='out_box' class='bor_col'>
    	<div id='title' class='t_head'>在线用户列表(<a href='MessageBoard.jsp'>进入留言板</a>)</div>
    	<hr class='bor_col'/>
    	<div><a href="LoginOut.jsp">注销</a></div>
    	<hr class='bor_col'/>
    		
		<%	
			
			
			@SuppressWarnings("unchecked")
			Set<UserInfo> set = (Set<UserInfo>)application.getAttribute("userSet");
			
			
			if(set != null && set.size() > 0){
				out.write("<div class='context t_head'>人数(" + set.size() + ")</div>");
				out.write("<hr class='bor_col'/>");
				
				for(UserInfo user : set){
					
					out.write("<div class='part'>");
					out.write("<div class='context'><img src='img/pic3.jpg' class='photo '></div>");
					if(user.getId() == cur_user.getId()){
						out.write("<div class='context p_name' >" + user.getName() + "(" + user.getId() + " 我)</div>");
					}else{
						out.write("<div class='context p_name' >" + user.getName() + "(" + user.getId() + ")</div>");
					}
					
					out.write("<div class='context mesg'></div>");
					out.write("</div>");
					out.write("<hr class='bor_col'/>");
				}
			}else{
				out.write("<div class='context t_head'>人数(0)</div>");
			}
		%>
		</div>
	</body>
	
</html>