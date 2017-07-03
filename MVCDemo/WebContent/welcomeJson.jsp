<%@page import="java.util.List"%>
<%@page import="com.mvc.tools.DBUtil"%>
<%@page import="com.study.mvc.model.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
<link rel="stylesheet" href="css/bg.css" />
<link rel="stylesheet" href="css/Login.css" />
<link rel="stylesheet" href="css/welcome.css" >
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	var listInfo = "";
	
	function getNumber(){
		alert($("#to").val())
		return $("#to").val();
	}
	
	function getData(page){
		$.post(
			"FindStudentServletJson?page=" + page,
			{
				condition:"name",
				name:$("#name").val()
			},
			function(data){
					listInfo = "";
					var i = 0;
					listInfo += "<table><caption>学生信息</caption>" + 
						"<tr><td>序号</td><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>毕业院校</td><td colspan=\"2\">操作</td></tr>";
					
					var chats=eval(data);
					if(chats[0].mesg != null){
						listInfo += "<tr><td colspan=\"7\">暂无数据</td></tr></table>";
					}else{
						$.each(chats, function(i){
							var info = chats[i]; //拿到一条数据
							listInfo += "<tr>" + 
							"<td>" + i + "</td>" + 
							"<td>" + info.id + "</td>" + 
							"<td>" + info.name + "</td>" + 
							"<td>" + info.age + "</td>" + 
							"<td>" + info.sex + "</td>" + 
							"<td>" + info.gradInst + "</td>" + 
							"<td><a href=\"ModifyStuServlet?id=" + info.id + "\">修改</a></td>" + 
							"<td><a href=\"UpdateServlet?action=stu_del&id=" + info.id + "\"'>删除</a></td></tr>";
						});
						listInfo += 
						"<tr><td colspan=\"2\"><a href=\"#\" onclick=\"getData('first')\"> 首页</a></td>" +
						"<td colspan=\"2\"><a href=\"#\" onclick=\"getData('pre')\">上页</a></td>" +
						"<td colspan=\"2\"><a href=\"#\" onclick=\"getData('nxt')\">下页</a></td>" +
						"<td><a href=\"#\" onclick=\"getData('last')\">尾页</a></td>" +
						"<td><a href=\"#\" onclick=\"getData(getNumber())\">跳</a>指定页<input type=\"number\" id=\"to\">";
						listInfo += "</table>";
					}
				$("#info").html(listInfo);
				}, "JSON");
				
					
				
	}
</script>
</head>
<body>
		<div id="layer1" >
    		<img src="img/bg.jpg" width="100%" height="100%"/>
    	</div>
	<c:if test="${empty sessionScope.user }">
		<jsp:forward page="LoginServlet"></jsp:forward>
	</c:if>
	
	
	<h1>${sessionScope.user.s_name },终于等到你！！！</h1>
	
	<div id="findCondition">
		<h3>检索条件</h3>
		<form action="" method="post">
			学号：<input type="text" name="id" /><br><br />
			姓名：<input type="text" name="name" id="name"/><br /><br />
			性别：<select name="sex">
						<option value=""></option>
						<option value="男">男</option>
						<option value="女">女</option>
				</select><br /><br />
			年龄：<input type="number" name="startAge" value="0" style="width:30px" />
			 --<input type="number" name="endAge" value="100" style="width:30px" /><br /><br />
			毕业院校：<select name="gradInst">
					<option value=""></option>
					<option value="西安工业大学">西安工业大学</option>
					<option value="西安科技大学">西安科技大学</option>
					<option value="西安皇家工业学院">西安皇家工业学院</option>
					<option value="西安草滩皇家工业学院">西安草滩皇家工业学院</option>
			   </select><br /><br />
			<input type="button" id="submit" value="查询" onclick="getData('first')"/>
		</form>
		
		
	</div>
	
	<div id="info">
		<table>
			<caption>学生信息</caption>
			<tr><td>序号</td><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>毕业院校</td><td colspan="2">操作</td></tr>
			<tr><td colspan="7">请输入查询条件Json</td></tr>
		</table>
	</div>
</body>
</html>