<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <%
		String path = request.getContextPath();  //取到绝对根目录
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
					<li class="inner_navig"  id="li_5"><a href="${pageScope.path}/content/classManger/ManagerTacher.jsp">查询班级信息</a></li>
					<li class="inner_navig"  id="li_6"><a href="${pageScope.path}/content/classManger/NotManagerTacher.jsp">查询未分班学员</a></li>
					<li class="inner_navig"  id="li_6"><a href="${pageScope.path}/content/classManger/classManager.jsp">任命班长</a></li>
					<li class="inner_navig"  id="li_6"><a href="${pageScope.path}/content/classManger/NotManagerTacher.jsp">添加学员</a></li>
					<li class="inner_navig"  id="li_6"><a href="#" onclick="chext()">开除学员</a></li>
				</ul>
			</div>
	
			<div id="show_info">
	<form action="${pageScope.path}/ManagerTeancherServlet?action=quealnotclassstudent&id=''" method="post">
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
			<td>身份证</td>
			<td>操作</td>
			</tr>
			<c:if test="${not empty requestScope.study}">
					<c:forEach var="clas" items="${requestScope.study}">
					<tr>
						<td>${clas.id}</td>
						<td>${clas.name}</td>
						<td>${clas.sex}</td>
						<td>${clas.age}</td>
						<td>${clas.tel}</td>
						<td>${clas.gradFrom}</td>
						<td>${clas.addr}</td>
						<td>${clas.email}</td>
						<td>${clas.idCard}</td>
             <td><a href="${pageScope.path}/ManagerTeancherServlet?action=insertstudents&studyid=${clas.id}" onclick="return Hint()">添加</a></td>
       
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