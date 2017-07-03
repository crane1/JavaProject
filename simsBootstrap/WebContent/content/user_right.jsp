<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%
		String path = request.getContextPath();
		pageContext.setAttribute("path", path);
	%>
</head>
<body>
		<li class="main_navig" id="li_1"><a href="${pageScope.path}/content/student/showStuInfo.jsp">个人操作</a></li>
		<c:choose>
			<c:when test="${sessionScope.user_right eq 't_leader' }">
				<li class="main_navig" id="li_2"><a href="${pageScope.path}/content/teamLeader/Group.jsp">组长操作</a></li>
			</c:when>
			<c:when test="${sessionScope.user_right eq 'c_monitor' }">
				<li class="main_navig" id="li_2"><a href="${pageScope.path}/content/classMonit/classMoniter.jsp">班长操作</a></li>
			</c:when>
			<c:when test="${sessionScope.user_right eq 'c_man_teacher' }">
				<li class="main_navig" id="li_2"><a href="${pageScope.path}/content/classManger/ManagerTacher.jsp">班主任操作</a></li>
			</c:when>
			<c:when test="${sessionScope.user_right eq 'c_teac_teacher' }">
				<li class="main_navig" id="li_2"><a href="#">任课老师操作</a></li>
			</c:when>
			<c:when test="${sessionScope.user_right eq 'normal_manager' }">
				<li class="main_navig" id="li_2"><a href="${pageScope.path}/content/admin/Admin.jsp">管理员操作</a></li>
			</c:when>
			<c:when test="${sessionScope.user_right eq 'admin' }">
				<li class="main_navig" id="li_2"><a href="${pageScope.path}/content/superAdmin/showAdmin.jsp">管理员操作</a></li>
			</c:when>
		</c:choose>
		<li class="main_navig" id="login_out"><a href="${pageScope.path}/loginout.jsp">注销</a></li>
</body>
</html>