<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>意外</title>
<link rel="stylesheet" href="css/bg.css" />
<link rel="stylesheet" href="css/all_text.css" />
</head>
<body>
	<div id="layer1" >
    	<img src="img/bg.jpg" width="100%" height="100%"/>
    </div>
	<h1>大哥，看我们意外逮到一只<%=session.getAttribute("qx_name") %>会员！！！</h1>
	<h1>他想去<%=session.getAttribute("req_qxName") %>区看看风景</h1>
</body>
</html>