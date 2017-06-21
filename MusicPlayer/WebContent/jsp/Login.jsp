<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
	<%
		String path = request.getContextPath();  //取到绝对根目录
		pageContext.setAttribute("path", path);
	%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录页面</title>
		<link rel="stylesheet" href="${pageScope.path}/css/bg.css" />
		<link rel="stylesheet" href="${pageScope.path}/css/main.css" />
		<script src="${pageScope.path}/js/jquery-1.7.2.min.js"></script>
		<script src="${pageScope.path}/js/login.js"></script>
		
		<script >
			var path = "<%=path%>"
		</script>
	</head>
	
	<c:if test="${not empty requestScope.chpwd}">
		<div style="color: red;">${requestScope.chpwd}</div>
	</c:if>
	
	<body style="text-align: center;" onload="getNewRand()" >
		
		<div id="layer1" >
    		<img src="${pageScope.path}/img/bg.jpg" width="100%" height="100%"/>
    	</div>
    	
    	
		<table  style="margin: 30px auto;text-align: center;" >
			<caption style="font-size:200%">登录页面</caption>
			<tr>
				<td class="left_td">账号</td>
				<td class="right_td" >
					<input type="text" id="userId" name="userId" placeholder="请输入账号">
				</td>
				<td class="right_td">
					<div id="c_userId" style="display: none;color: red;">账号不能为空</div>
				</td>
			</tr>
			<tr>
				<td class="left_td">密码</td>
				<td class="right_td" >
					<input type="password" id="pwd" name="pwd" placeholder="请输入密码">
				</td>
				<td class="right_td">
					<div id="c_password" style="display: none;color: red;">密码不能为空</div>
				</td>
			</tr>
			<tr>
				<td class="left_td">权限选择</td>
				<td colspan="2"   class="right_td">
					<select name="permissions" id="permissions" >
						<option value="stu">学员</option>
						<option value="t_leader">组长</option>
						<option value="c_monitor">班长</option>
						<option value="c_man_teacher">班主任</option>
						<!-- <option value="c_teac_teacher">任课老师</option> -->
						<option value="normal_manager">一般管理员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td height="30px"  class="left_td">验证码</td>
				<td class="right_td">
					<input type="text" id="randNum" name="randNum" onblur="checkImgNum()">
					<img id="image" alt="1" src="${pageScope.path}/identifyNum" onclick="getNewRand()">
				</td>
				<td>
					<div id="c_randNum" style="display: none;color: red;">验证码不能为空</div>
				</td>
			</tr>
			<tr>
				<td colspan="3" >
					<button  onclick="return login()" >登录</button>
					&nbsp; <input type="reset" value="重置">
					&nbsp; <a href="regist.jsp">注册</a>
					<a href="PasswordBack.jsp">密码找回</a>
					</td>
			</tr>
			<tr>
				<td colspan="3"><div id="loginErr" style="color: red;"></div></td>
			</tr>
			
		</table>
	</body>
</html>