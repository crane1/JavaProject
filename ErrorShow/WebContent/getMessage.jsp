<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bean.MessageInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border-collapse: collapse;
		border:1px solid gray;
	}
</style>
</head>
<body>
	<table border="1px solid gray">
		<tr><td>楼层</td><td>标题</td><td>用户</td><td>内容</td><td>时间</td></tr>
		<%
			List<MessageInfo> list = (List<MessageInfo>)application.getAttribute("Message");
			
			if(list == null){
				out.write("<tr colspan=\"4\"><td>暂无留言</td></tr>");
			}else{
				for(int i = 0; i < list.size(); i++){
					MessageInfo mes = list.get(i);
					out.write("<tr><td>"
						+ (i+1) + "楼</td><td>"
						+ mes.getTitle() + "</td><td>" 
						+ mes.getUserName() + "</td><td>" 
						+ mes.getContent() + "</td><td>" 
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mes.getDate()) + "</td></tr>");
				}
			}
		
		%>
	</table>
	
</body>
</html>