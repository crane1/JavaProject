<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
<form action="${pageScope.path}/AdminClassServlet?action=appClTeacher" method="post">
		<table>
			<tr>
				<td>
					请输入待任命的班级ID：
				</td>
				<td>
					<input type="text" id="clID" name="clID" placeholder="请输入班级ID">
				</td>
			</tr>
			<tr>
				<td>
					请输入你需要任命的任课老师ID：
				</td>
				<td>
					<input type="text" id="clTeacher" name="clTeacher" placeholder="请输入任课老师ID">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交">
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>