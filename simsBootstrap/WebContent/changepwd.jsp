<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>密码找回页面</title>
		<link rel="stylesheet" href="css/bg.css" />
		<link rel="stylesheet" href="css/login.css" />
		<script src="js/login.js"></script>
	</head>
	
	<c:if test="${not empty requestScope.chpwd}">
		<div style="color: red;" align="center">${requestScope.chpwd}</div>
	</c:if>
	
<body>
		<div id="layer1" >
    		<img src="img/bg.jpg" width="100%" height="100%"/>
    	</div>
	<form action="updateServlet?action=changepwd&id=<%=request.getParameter("id")%>" method="post">
		<table style="margin: 30px auto;text-align: center;top: 100px;">
			<caption>
				<h1>密码找回</h1>
			</caption>
		
			<tr>
				<td>
					请输入你的新密码：
				</td>
				<td>
					<input type="password" id="pwd" name="pwd">
				</td>
			</tr>
			<tr>
				<td>
					请再次输入你的新密码：
				</td>
				<td>
					<input type="password" id="apwd" name="apwd">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit"  value="提交" >
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>