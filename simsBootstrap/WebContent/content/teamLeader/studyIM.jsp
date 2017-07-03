<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<%
		String path = request.getContextPath();
		pageContext.setAttribute("path", path);
	%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主页</title>
		<link rel="stylesheet" href="${pageScope.path}/css/bg.css" />
		<link rel="stylesheet" href="${pageScope.path}/css/main.css" />
		<script src="${pageScope.path}/js/main.js"></script>
		<script type="text/javascript">
            function Hint(){
            		  if(confirm("确定")){
            			  return true;
            		  }else{
            			  return false;
            		  }
            	  }
        </script>
       <style type="text/css">
  
       </style>	
	</head>
<body>
		<div id="layer1" >
    		<img src="${pageScope.path}/img/bg.jpg" width="100%" height="100%"/>
    	</div>
		<div id="outer">
			<div id="logo" class="div_b show">学生信息管理系统</div>
			<!--主导航页面-->
			<div id="main_navig" class="div_b">
				<ul class="main_navig">
					<jsp:include page="../user_right.jsp"></jsp:include>
				</ul>
			</div>
			<div id="inner_navig" class="div_b">
				<ul class="inner_navig">
					<li class="inner_navig"  id="li_5"><a href="${pageScope.path}/content/teamLeader/Group.jsp">查看本组员工信息</a></li>
					<li class="inner_navig"  id="li_6"><a href="${pageScope.path}/content/teamLeader/studyIM.jsp">查看未分组员工信息</a></li>
				</ul>
			</div>
	
			<div id="show_info">
				<form action="${pageScope.path}/teamServlet?action=teamselect" method="post">
		<table border="2" style="text-align: center; width: 850px">
			<tr>
				<td colspan="11" style="text-align: center;">学员信息一览表</td>
			</tr>
			<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>电话</td>
			<td>毕业院校</td>
			<td>住址</td>
			<td>邮箱</td>		
			<td>组号</td>
			<td>身份证</td>
			<td>操作</td>
			</tr>
			<c:if test="${not empty requestScope.team}">
			<c:forEach var="stu" items="${requestScope.team}">
			<tr>
			 <td>${stu.id}</td>
             <td>${stu.name}</td>
             <td>${stu.sex}</td>
             <td>${stu.age}</td>
             <td>${stu.tel}</td>
             <td>${stu.gradFrom}</td>
             <td>${stu.addr}</td>
             <td>${stu.email}</td>
             <td>${stu.teamID}</td>
             <td>${stu.idCard}</td>
             
             <td><a href="${pageScope.path}/teamServlet?action=studentupdate&s_id=${stu.id}" onclick="return Hint()">添加</a></td>
             </tr>
			</c:forEach>
			</c:if>
			<tr>
				<td colspan="11" align="center">
				<input type="submit" value="查看">
				</td>
			</tr>
		</table>
	</form>

			</div>
			<div id="footer" class="div_b">链接信息区</div>
		</div>
	</body>

</html>