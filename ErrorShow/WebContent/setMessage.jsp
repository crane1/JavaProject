<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Message.jsp" method="post">
		标题：<input type="text" id="title" name="title"><br>
		用户：<input type="text" id="username" name="username"><br>
		内容<textarea  id="content" name="content">
		</textarea>
		
		<br>
		<input type="submit" value="提交">
	</form>
	<a href="getMessage.jsp">查看留言</a>
	<%
		String info = (String)request.getAttribute("info");
		if(info != null && !info.equals("")){
			out.write("<div style=\"color:red\">" + info + "</div>");
		}
		
		String erro = request.getParameter("erro");
		if(erro != null && !erro.equals("")){
			out.write("<div style=\"color:red\">" + erro + "</div>");
		}
	%>
	
</body>
</html>