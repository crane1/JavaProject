<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body style="margin: 10px 30px">
		<form action="LoginServlet" method="post">
			<table style="text-align: center;border: 3px solid green" >
				<caption>登录</caption>
				<tr>
					<td>用户编号:</td>
					<td><input type="text" id="userid" name="userid" placeholder="请输入ID"></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" id="pwd" name="pwd"  placeholder="请输入密码"></td>
				</tr>
				<tr>
					<td colspan="2" id="td_btn">
						<input type="submit" value="登录">
						<input type="reset" value="重置">
					</td>
				</tr>
				<%
					String errMsg=(String)request.getAttribute("err");
				    if(errMsg!=null){
                %>
						<tr>
						  <td colspan="2" id="td_btn"><div id="msg" style="color:red"><%=errMsg%></div></td>
						</tr>
				  <%
				  }
				%>
			</table>
		</form>
</body>
</html>