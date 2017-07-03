<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>屏蔽指定IP</title>
</head>
<body>
	<%
		String forbadIP = application.getInitParameter("ip");
		String remoteIP = request.getRemoteHost();
		
		if(forbadIP.equals(remoteIP)){
			response.sendRedirect("ErroShow.jsp");
			return;
		}
	%>
	
	如果你看到了这内容，那么你的IP没有被封杀！！！恭喜你！！！
</body>
</html>