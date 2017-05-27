
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户注册-小白的一生</title>
		<link rel="stylesheet" href="css/bg.css" />
		<link rel="stylesheet" href="css/register.css" />
		<script type="text/javascript" src="js/check_user.js" ></script>
	</head>

	<body>
		<div id="layer1" >
    		<img src="img/bg.jpg" width="100%" height="100%"/>
    	</div>
    	<h1>欢迎来到小白的一生</h1>
    	<div id="main">
			<form action="RegisterServlet" method="post">
				<div id="outer">
					<div id="head">注册</div>
					<div class="block">
						<input type="text" name="id" placeholder="用户名" id="id" class="input">
						<span id="check_img" style="display: inline;"><img src="img/check.png"/ id="check"></span>
						<div style="color: red;display: none;" id="id_promt">用户名已存在!!!</div>
					</div>
					<div class="block">
						<input type="password" name="pwd" placeholder="密码" id="pwd" class="input">
						<div style="color: red;display: none;" id="pwd_promt">密码不能为空</div>
					</div>
					<div class="block">
						<input type="text" name="name" placeholder="昵称" id="name" class="input">
					</div>
					<div class="block"><input type="checkbox" class="inline"><label class="inline">下次自动登录</label></div>
					<div class="block"><input type="submit" value="注册" id="submit"></div>
				</div>
			</form>
		</div>
	</body>
	<script>
		<%
			String error = request.getParameter("error");
			if(error != null){
				if(error.equals("id_empty")){
					out.write("alert('给你说了，用户名不能为空！！！')");
				} else if(error.equals("pwd_empty")){
					out.write("alert('给你说了，密码不能为空！！！')");
				} else if(error.equals("id_has")){
					out.write("alert('给你说了，用户名重复了！！！')");
				} else if(error.equals("add_fail")){
					out.write("alert('后台出错了，用户添加失败！！！')");
				}
			}
		%>
	</script>
</html>