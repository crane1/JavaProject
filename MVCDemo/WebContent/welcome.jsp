<%@page import="java.util.List"%>
<%@page import="com.study.mvc.tools.DBUtil"%>
<%@page import="com.study.mvc.model.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>

<style type="text/css">
	table{
		border-collapse: collapse;
		border:2px solid gray;
		margin:0 auto;
	}
	td{
		border:1px solid gray;
		padding:4px;
	}
	
	caption{
		font-size: 200%;
	}
	h1{
		text-align: center;
	}
</style>
</head>
<body>
	<%
		Student stu = (Student)session.getAttribute("user");
		if(stu == null){
			request.getRequestDispatcher("LoginServlet").forward(request, response);
			return;
		}
	%>
	
	<h1>${sessionScope.user.s_name },终于等到你！！！</h1>
	<%
	DBUtil dbutil = DBUtil.getInstance();
	List<Student> list = dbutil.queryStudents();
	%>
	
	<table>
		<caption>学生信息</caption>
		<tr><td>序号</td><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>毕业院校</td><td colspan="2">操作</td></tr>
		<%
			if(list == null){
				out.write("<tr><td colspan='8'>暂无数据</td></tr>");
			}else{
				int i = 1;
				for(Student s : list){
					out.write("<tr><td>" + i++
							+ "<td>" + s.getS_id()
							+ "</td><td>" + s.getS_name()
							+ "</td><td>" + s.getS_sex()
							+ "</td><td>" + s.getS_age()
							+ "</td><td>" + s.getS_gradInst()
							+ "</td><td><a href='#'>修改</a>"
							+ "</td><td><a href='#'>删除</a></td></tr>");
				}
			}
		%>
	</table>
</body>
</html>