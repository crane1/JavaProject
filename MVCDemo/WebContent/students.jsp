<%@page import="com.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.jdbc.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
	table{
		border-collapse: collapse;
		border:2px solid gray;
	}
	td{
		border:1px solid gray;
		padding:4px;
	}
	caption{
		font-size: 200%;
	}
</style>
</head>
<body>
<%
	DBUtil dbutil = DBUtil.getInstance();
	List<Student> list = dbutil.queryStudents();
%>
	<table>
		<caption>学生信息</caption>
		<tr><th>学号</th><th>姓名</th><th>性别</th><th>年龄</th><th>毕业院校</th><th colspan="2">操作</th></tr>
		<%
			if(list == null){
				out.write("<tr><td colspan='7'>暂无数据</td></tr>");
			}else{
				for(Student stu : list){
					out.write("<tr><td>" + stu.getS_id()
							+ "</td><td>" + stu.getS_name()
							+ "</td><td>" + stu.getS_sex()
							+ "</td><td>" + stu.getS_age()
							+ "</td><td>" + stu.getS_gradInst()
							+ "</td><td><a href='#'>修改</a>"
							+ "</td><td><a href='#'>删除</a></td></tr>");
				}
			}
		%>
	</table>
</body>
</html>