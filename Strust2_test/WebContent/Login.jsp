<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

	s:actionerror{
		color:red;
	}
</style>
</head>
<body>
	<form action="login">
		<label >姓名：</label><input type="text" name="name"/><br/>
		<label >电话：</label><input type="tel" name="tel"/><br/>
		<label >年龄：</label><input type="number" name="age"/><s:property value="mesg"/> <br/>
		<label >爱好：</label>
			<input type="checkbox" name="love" value=1/>打游戏
			<input type="checkbox" name="love" value=2/>泡妞
			<input type="checkbox" name="love" value=3/>逛街<br/>
		<input type="submit" value="登录">
	</form>
	<s:fielderror/>
</body>
</html>