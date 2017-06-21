<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<% %>
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
		<script type="text/javascript" src="${pageScope.path}/js/jquery-1.7.2.min.js"></script>
		
		<style type="text/css">
			.left{
				text-align: left;
			}
			td{
				padding:3px;
			}
		</style>
		<script>
			var listInfo = "";
			
			function getNumber(){
				return $("#to").val();
			}
			
			function getData(page){
				$.post(
					"<%=path%>/SuperAdminServlet?page=" + page,
					{
						oper:"query"
					},
					function(data){
						listInfo = "";
						var i = 0;
						listInfo += "<table><caption>管理员信息</caption>" + 
							"<tr><td>序号</td><td>学号</td><td>姓名</td><td>电话</td><td>操作</td></tr>";
						
						var chats=eval(data);
						if(chats[0].mesg != null){
							listInfo += "<tr><td colspan=\"7\">暂无数据</td></tr></table>";
						}else{
							$.each(chats, function(i){
								var info = chats[i]; //拿到一条数据
								listInfo += "<tr>" + 
								"<td>" + (i+1) + "</td>" + 
								"<td>" + info.id + "</td>" + 
								"<td>" + info.name + "</td>" + 
								"<td>" + info.tel + "</td>" + 
								"<td><a href=\"#\" onclick=\"getDelMesg("+info.id+")\">罢免</a></td></tr>";
							});
							
							listInfo += 
							"<tr><td ><a href=\"#\" onclick=\"getData('first')\"> 首页</a></td>" +
							"<td ><a href=\"#\" onclick=\"getData('pre')\">上页</a></td>" +
							"<td ><a href=\"#\" onclick=\"getData('nxt')\">下页</a></td>" +
							"<td><a href=\"#\" onclick=\"getData('last')\">尾页</a></td>" +
							"<td><a href=\"#\" onclick=\"getData(getNumber())\">跳到指定页</a><input type=\"number\" id=\"to\">";
							
							listInfo += "</table>";
						}
						$("#info").html(listInfo);
					}, "JSON"
				);
			}
			
			function getDelMesg(id){
				$.post(
					"<%=path%>/SuperAdminServlet?id=" + id,
					{
						oper:"del"
					},
					function(data){
						$("#info").html(data);
					}
				)
			}
			$(function(){
				getData("first");
			});
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
				<ul class="inner_navig">
					<li class="inner_navig"  id="li_5"><a href="${pageScope.path}/content/superAdmin/showAdmin.jsp">查看管理员</a></li>
					<li class="inner_navig"  id="li_6"><a href="${pageScope.path}/content/superAdmin/addAdmin.jsp">添加管理员</a></li>
					<!--  <li class="inner_navig"  id="li_7"><a href="${pageScope.path}/content/student/mod_pwd.jsp">密码修改</a></li>
					-->
				</ul>
			</div>
			<div id="show_info">
				<div id="info" align="center">
					<table>
						<tr><td>序号</td><td>学号</td><td>姓名</td><td>电话</td><td>查看详情</td></tr>
						<tr><td colspan="5">暂无数据</td></tr>
					</table>
				</div>
	 		</div>
			<div id="footer" class="div_b">链接信息区</div>
		</div>
	</body>

</html>