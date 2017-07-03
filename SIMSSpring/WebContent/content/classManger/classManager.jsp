<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<%
		String path = request.getContextPath();  //取到绝对根目录
		pageContext.setAttribute("path", path);
	%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主页</title>
		<link rel="stylesheet" href="${pageScope.path}/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageScope.path}/css/bg.css" />
		<link rel="stylesheet" href="${pageScope.path}/css/main.css" />
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
				<ul class="inner_navig">
					<li class="inner_navig"  id="li_5"><a class="btn btn-primary" href="${pageScope.path}/content/classManger/ManagerTacher.jsp">查询班级信息</a></li>
					<li class="inner_navig"  id="li_6"><a class="btn btn-primary" href="${pageScope.path}/content/classManger/NotManagerTacher.jsp">查询未分班学员</a></li>
					<li class="inner_navig"  id="li_6"><a class="btn btn-primary" href="${pageScope.path}/content/classManger/classManager.jsp">任命班长</a></li>
					<li class="inner_navig"  id="li_6"><a class="btn btn-primary" href="${pageScope.path}/content/classManger/NotManagerTacher.jsp">添加学员</a></li>
					<li class="inner_navig"  id="li_6"><a class="btn btn-primary" href="#" onclick="chext()">开除学员</a></li>
				</ul>
			</div>
			<div id="show_info">
			<form action="classmanagee" method="post">
				<table>
				<tr>
				<td>班ID</td>
				<td><input type="text" id="classid" name="classid"></td>
				</tr>
				<tr>
				<td>学生ID</td>
				<td><input type="text" id="studyid" name="studyid"></td>
				</tr>
				</tr>
				<tr>
				<td colspan="2" style="text-align: center;"><input type="submit" value="确定"></td>
				</tr>
				</table>
				</form>
			</div>
			<div id="footer" class="div_b">链接信息区</div>
		</div>
	</body>

</html>