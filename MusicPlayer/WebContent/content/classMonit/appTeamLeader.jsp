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
			<form action="${pageScope.path}/ClassServlet?action=appteamleader" method="post">
				<table>
					<tr>
						<td>组ID</td>
						<td><input type="text" name="teamid" id="teamid"
							placeholder="请输入组ID"></td>
					</tr>
					<tr>

						<td>新组长ID</td>
						<td><input type="text" name="newleaderid" id="newleaderid"
							placeholder="请输入新组长ID"></td>
					</tr>



					<%-- <c:if test="${not empty requestScope.clas}">
				          <tr>
					            <td>学号</td>
								<td>姓名</td>
								<td>性别</td>
								<td>年龄</td>
								<td>毕业院校</td>
								<td>电话</td>						
								<td>地址</td>
								<td>身份证</td>
								<td>邮箱</td>
								<td>组ID</td>
								<td>班级ID</td>
								<td>组长</td>
								<td>班长</td>
								<td>操作</td>
				          </tr>
				          <c:forEach var="team" items="${requestScope.clas}">
				          <tr>				          
				                <td>${clas.id}</td>
								<td>${clas.name}</td>
								<td>${clas.sex}</td>
								<td>${clas.age}</td>
								<td>${clas.gradFrom}</td>
								<td>${clas.tel}</td>							
								<td>${clas.addr}</td>
								<td>${clas.idCard}</td>
								<td>${clas.email}</td>
								<td>${clas.teamID}</td>							
								<td>${clas.classID}</td>
								<td>${clas.t_leader}</td>
								<td>${clas.c_monitor}</td>
								<td><input type="radio" name="" value="0"> </td>
						</tr>
						</c:forEach>
				     </c:if>
				     
				     <c:if test="empty requestScope.team">
				      <tr>
					            <td>学号</td>
								<td>姓名</td>
								<td>性别</td>
								<td>年龄</td>
								<td>毕业院校</td>
								<td>电话</td>						
								<td>地址</td>
								<td>身份证</td>
								<td>邮箱</td>
								<td>组ID</td>
								<td>班级ID</td>
								<td>组长</td>
								<td>班长</td>
								<td>操作</td>
				          </tr>
				          <tr>
				                <td colspan="15">没有任何信息</td>
				          </tr>
				     </c:if>--%>
					<tr>
						<td></td>
						<td><input type="submit" value="提交"><input
							type="reset" value="重置"></td>
					</tr>
				</table>

			</form>
		</div>
		<div id="footer" class="div_b">链接信息区</div>
	</div>

</body>
</html>

