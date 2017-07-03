<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/Strust2_test/js/jquery-1.7.2.min.js"></script>
<script >
	function getData(){
		$.post(
			"hello.action",
			{
				id:$("#id").val(),
				name:$("#name").val()
			},
			function(data){
				$("#mesg").html(data)
			}
		)
	}

</script>
</head>
<body>
	hello world!!
	<hr>
	
	ID：<input type="text" id="id" ><br>
	Name：<input type="text" id="name" ><br>
	<div id="mesg" style="color:red;"></div>
	<a href="hello.action">登录</a>
</body>
</html>