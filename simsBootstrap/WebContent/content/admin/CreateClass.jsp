<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		String path = request.getContextPath();
		pageContext.setAttribute("path", path);
	%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>班级注册页面</title>
		<link rel="stylesheet" href="${pageScope.path}/css/bg.css" />
		<link rel="stylesheet" href="${pageScope.path}/css/main.css" />
		<script src="${pageScope.path}/js/main.js"></script>

	<script type="text/javascript">
	var yj={};
	yj.$=function(element){
	 	return document.getElementById(element);
	}
	yj.check=function(elementIn,elementDis){
		if(elementIn.value==null||elementIn.value==""){
			elementDis.style.display="block";
			return false;
		}else{				
			return true;
		}
	}
	yj.checkAll=function(){
		yj.$("c_id").style.display="none";
		yj.$("c_name").style.display="none";
		yj.$("c_manTeacherID").style.display="none";
		yj.$("c_teacTeacherID").style.display="none";
		
		
		if((!this.check(yj.$("id"),yj.$("c_id")))|
		(!this.check(yj.$("name"),yj.$("c_name")))|
		(!this.check(yj.$("teacTeacherID"),yj.$("c_teacTeacherID")))|
		(!this.check(yj.$("manTeacherID"),yj.$("c_manTeacherID")))){
			return false;
		}else{					
			return true;
		}
	}
</script>
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
				<ul>
					<li class="inner_navig"><a href="${pageScope.path}/AdminClassServlet?action=classAll">查询所有班级</a></li>
					<li class="inner_navig"><a href="${pageScope.path}/content/admin/CreateClass.jsp">创建新班级</a></li>
					<li class="inner_navig"><a href="${pageScope.path}/content/admin/appClassLeader.jsp">任命班主任</a></li>
				</ul>
			</div>
		<div id="show_info">
		<form action="${pageScope.path}/AdminClassServlet?action=addClass" method="post">
		<table align="center" border="1" style="text-align: center;">
			<caption>班级注册</caption>
			<tr>
				<td>班级ID</td>
				<td><input type="text" id="id" name="id">
					<div id="c_id" style="display: none;color: red;">班级ID不能为空</div>
				</td>
			</tr>
			<tr>
				<td>班级名称</td>
				<td><input type="text" id="name" name="name">
					<div id="c_name" style="display: none;color: red;">班级名称不能为空</div>
				</td>
			</tr>
			<tr>
				<td>班主任ID</td>
				<td><input type="text" id="manTeacherID" name="manTeacherID">
					<div id="c_manTeacherID" style="display: none;color: red;">班主任不能为空</div>
				</td>
			</tr>
			<tr>
				<td>任课老师ID</td>
				<td><input type="text" id="teacTeacherID" name="teacTeacherID">
					<div id="c_teacTeacherID" style="display: none;color: red;">任课老师为空</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" onclick="return yj.checkAll()" value="提交" >
					<input type="reset" value="重置">
				</td>
			</tr>
			<c:if test="${not empty requestScope.addClMeg}">
				<tr>
					<td colspan="2">${requestScope.addClMeg}</td>
				</tr>
			</c:if>
		</table>
	</form>
		</div>
			<div id="footer" class="div_b">链接信息区</div>
		</div>
	</body>
</html>