<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录页面</title>
		<link rel="stylesheet" href="css/bg.css" />
		<link rel="stylesheet" href="css/login.css" />
		<script src="js/login.js"></script>
	</head>
	
	<c:if test="${not empty requestScope.chpwd}">
		<div style="color: red;">${requestScope.chpwd}</div>
	</c:if>
	
	<body style="text-align: center;" onload="getNewRand()" >
		
		<div id="layer1" >
    		<img src="img/bg.jpg" width="100%" height="100%"/>
    	</div>
		<form action="LoginServlet" method="post">
			<table  style="margin: 30px auto;text-align: center;" >
				<caption>
					<h1>登录页面</h1>
				</caption>
				<tr>
					<td class="left_td">账号</td>
					<td class="right_td"><input type="text" id="userId" name="userId" placeholder="请输入账号">
									<div id="c_userId" style="display: none;color: red;">账号不能为空</div>
					</td>
					<td><a href="#" onclick="checkUserId()">验证用户名</a></td>
				</tr>
				<tr>
					<td class="left_td">密码</td>
					<td class="right_td"><input type="password" id="pwd" name="pwd" placeholder="请输入密码">
									<div id="c_password" style="display: none;color: red;">密码不能为空</div>
					</td>
					<td>
					 	<div id="checkuUserMsg" style="display: none;"></div>
					 </td>
				</tr>
				<tr>
					<td class="left_td">权限选择</td>
					<td colspan="3"   class="right_td">
						<select name="permissions" id="permissions" onchange="getPermissions()">
							<option value="stu">学员</option>
							<option value="t_leader">组长</option>
							<option value="c_monitor">班长</option>
							<option value="c_man_teacher">班主任</option>
							<!-- <option value="c_teac_teacher">任课老师</option> -->
							<option value="normal_manager">一般管理员</option>
							<!-- <option value="">超级管理员</option> -->
						</select>
					</td>
				</tr>
				<tr>
					<td height="30px"  class="left_td">验证码</td>
					<td class="right_td"><input type="text" id="randNum" name="randNum" onblur="checkImgNum()">
						<div id="c_randNum" style="display: none;color: red;">验证码不能为空</div>
					</td>
					<td>
						<img id="image" alt="1" src="imgServlet" onclick="getNewRand()">
					</td>
				</tr>
				<tr>
					<td colspan="3" ><input type="submit" onclick="return yj.checkAll()" value="登录">
						&nbsp; <input type="reset" value="重置">
						&nbsp; <a href="regist.jsp">注册</a>
						<a href="PasswordBack.jsp">密码找回</a>
						</td>
				</tr>
				<c:if test="${not empty requestScope.loginErr}">
					<tr>
						<td colspan="3"><div id="loginErr" style="color: red;">${requestScope.loginErr}</div></td>
					</tr>
				</c:if>
			</table>
		</form>
	</body>
</html>