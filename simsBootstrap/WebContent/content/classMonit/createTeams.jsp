<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<%
		String path = request.getContextPath();
		pageContext.setAttribute("path", path);
	%>	
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主页</title>
		<link rel="stylesheet"href="${pageScope.path}/css/bg.css" />
		<link rel="stylesheet"href="${pageScope.path}/css/main.css" />
		<script src="${pageScope.path}/js/main.js"></script>
	</head>
	
	<body>
		<div id="layer1" >
    		<img src="${pageScope.path}/img/bg.jpg" width="100%" height="100%"/>
    	</div>
		<div id="outer">
			<div id="logo" class="div_b show">学生信息管理系统</div>
			<!--主导航页面-->
			<div id="main_navig" class="div_b">
				<ul class="main_navig">
					<jsp:include page="../user_right.jsp"></jsp:include>
				</ul>
			</div>
		<div id="inner_navig" class="div_b">
			<ul>
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/classMoniter.jsp">班信息查询</a></li>
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/classStuInfo.jsp">班级成员查询</a></li>
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/createTeams.jsp">创建组</a></li>
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/checkTeamStudent.jsp">组信息查询</a></li>
				<li class="inner_navig"><a href="${pageScope.path}/content/classMonit/appTeamLeader.jsp">替换组长</a></li>
			</ul>
		</div>
		<div id="show_info">
	<form action="${pageScope.path}/ClassServlet?action=caeateTeams" method="post">
		<table>
			<tr>
				<td>组&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;D:</td>
				<td><input type="text" name="id" placeholder="请输入组ID"></td>
			</tr><br>
			<tr>
				<td>组&nbsp;&nbsp;名&nbsp;&nbsp;称:</td>
				<td><input type="text" name="name" placeholder="请输入组名称"></td>
			</tr>
			<tr>
				<td>组&nbsp;&nbsp;长&nbsp;&nbsp;I&nbsp;D:</td>
				<td><input type="text" name="monitorid" placeholder="请输入组长ID"></td>
			</tr>
 			<tr>
				<td>班&nbsp;&nbsp;级&nbsp;&nbsp;I&nbsp;D:</td>
				<td><input type="text" name="classsid" placeholder="班级ID"></td>
			</tr>
			<tr>
			<!--	<td>任课&nbsp;老师:</td>
				<td><input type="text" placeholder="请输入任课老师姓名"></td>
			</tr> -->
			<tr>
				<td colspan="2"><input type="submit" value="提交"><input type="reset"
					value="重置"></td>
			</tr>
		</table>
	</form>
	</div>
		<div id="footer" class="div_b">链接信息区</div>
	</div>
	
</body>
</html>