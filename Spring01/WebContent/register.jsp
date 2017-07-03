<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>love</title>
		
	</head>
	<body>
		<s:actionmessage/>
		<form action="regist" method="post">
			ID:<input type="text" id="id" name="id" maxlength="10"><br/>
			Name:<input type="text" id="name" name="name" maxlength="10"><br/>
			Age:<input type="number" id="age" name="age" maxlength="3"><br/>
			Sex:<input type="radio" id="sex" name="sex" value="0">男<input type="radio" id="sex" name="sex" value="1">女<br/>
			GradFrom:<input type="text" id="gradFrom" name="gradFrom" maxlength="100"><br/>
			<input type="submit" value="提交">
		</form>
	</body>
</html>