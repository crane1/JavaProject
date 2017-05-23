<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录页面</title>
		<link rel="stylesheet" href="css/bg.css" />
		<link rel="stylesheet" href="css/login.css" />
		<script type="text/javascript" src="js/login_check.js" ></script>
	</head>
	<body>
		<div id="layer1" >
    		<img src="img/bg1.jpg" width="100%" height="100%"/>
    	</div>
	<%
		//保存cooki值
		String id="";
		String pwd="";
		//取出Cookie
		Cookie [] c=request.getCookies();
		if(c!=null){
			for(int i=0;i<c.length;i++){
			    if(c[i].getName().equals("id")){
			        id=c[i].getValue();
			    }else if(c[i].getName().equals("pwd")){
			    	pwd=c[i].getValue();
			    }
			}
		}else{
			System.out.println("没有cookie");
		}
	%>
		<form method="post" action="LoginServlet">
			<table>
				<caption>登录</caption>
				<tr>
					<td>用户ID:</td>
					<td><input type="text" id="userid" name="userid" value="<%=id %>" placeholder="请输入ID"></td>
				</tr>
				<tr>
					<td>密&emsp;码:</td>
					<td><input type="password" id="pwd" name="pwd" value="<%=pwd %>" placeholder="请输入密码"></td>
				</tr>
				<tr>
					<td colspan="2" id="td_btn">
						<input type="submit" value="登录" onclick="return check_empty()">
						<input type="reset" value="重置">
						<input type="checkbox" name="remember" value="true"/><span id="remember">10天内自动登录</span>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
	<script> 
		//取出传回来的参数error并与id_empty和pwd_empty比较
		var errori ='<%=request.getParameter("error")%>';
		if(errori == "id_empty"){
			alert("用户名不能为空！");
		}else if(errori == "pwd_empty"){
			alert("密码不能为空！");
		}else if(errori == "error"){
			alert("用户名或密码错误！")
		}
		
	</script>
</html>