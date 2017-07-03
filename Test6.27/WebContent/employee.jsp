<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table,td{
				border:1px solid gray;
				border-collapse: collapse;
				color:white;
				
			}
			#layer1{
				position: fixed;
				left: 0px;
				top: 0px;
				width: 100%;
				height: 130%;
				z-index: -1;
			}
		</style>
		<script src="js/jquery-1.7.2.min.js"></script>
		<script >
		$(function(){
			getData("first");
		})
		function getData(page) {
			var listInfo = "";
			//请求所有员工数据
			$.post(
					"ShowEmployeeServlet",
				{
					page:page
				},
				function(data) {
					var employee=eval(data);
					listInfo = "";
					var i = 0;
					listInfo += "<table ><caption>雇员信息</caption>" + 
						"<td>序号</td><td>工号</td><td>姓名</td><td>工资</td><td>年龄</td>";
					if(employee == null){
						listInfo += "<tr><td colspan=\"5\">暂无数据</td></tr></table>";
					}else{
						$.each(employee, function(i,info){
						    listInfo += "<tr>" + 
						    "<td>" + i + "</td>" + 
							"<td>" + info.empon + "</td>" + 
							"<td>" + info.name + "</td>" + 
							"<td>" + info.salary + "</td>" + 
							"<td>" + info.age + "</td></tr>";
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
				},
				"JSON"
			);
		}

		function getNumber(){
			return $("#to").val();
		}
			
		</script>
	
	</head>
	<body>
		<div id="layer1" >
    		<img id="main_bg" src="img/navbg.jpg" width="100%" height="100%"/>
    	</div>
		<div id="info" align="center"></div>
	</body>
</html>