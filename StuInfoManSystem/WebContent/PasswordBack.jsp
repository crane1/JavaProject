<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>密码找回页面</title>
		<link rel="stylesheet" href="css/bg.css" />
		<link rel="stylesheet" href="css/login.css" />
		<script src="js/login.js"></script>
		<c:if test="${not empty requestScope.chpwd}">
		<div style="color: red;">${requestScope.chpwd}</div>
	</c:if>
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
			yj.$("c_tel").style.display="none";
			yj.$("c_idCard").style.display="none";
			yj.$("c_email").style.display="none";
			
			if((!this.check(yj.$("id"),yj.$("c_id")))|
			(!this.check(yj.$("tel"),yj.$("c_tel")))|
			(!this.check(yj.$("idCard"),yj.$("c_idCard")))|
			(!this.check(yj.$("email"),yj.$("c_email")))){
				return false;
			}else{					
				return true;
			}
		}
</script>
</head>
<body>
   <div id="layer1">
    		<img src="img/bg.jpg" width="100%" height="100%"/>
    	</div>
	<form action="QueryServlet?action=findpwd" method="post" >
		<table border="1" style="margin: 100px auto;text-align: center;">
			<caption><h1>密码找回页面</h1></caption>
			<tr>
				<td>请输入需要找回的账号：</td>
				<td><input type="text" id="id" name="id">
					<div id="c_id" style="display: none;color: red;">账号不能为空</div>
				</td>
			</tr>
			<tr>
				<td>请输入手机号：</td>
				<td><input type="number" id="tel" name="tel">
					<div id="c_tel" style="display: none;color: red;">手机号不能为空</div>				
				</td>
			</tr>
			<tr>
				<td>请输入身份证号：</td>
				<td><input type="text" id="idCard" name="idCard">
					<div id="c_idCard" style="display: none;color: red;">身份证号不能为空</div>
				</td>
			</tr>
			<tr>
				<td>请输入邮箱：</td>
				<td><input type="text" id="email" name="email">
					<div id="c_email" style="display: none;color: red;">邮箱不能为空</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="submit" onclick="return yj.checkAll() " value="提交" >
					<input type="reset" value="重置" >
				</td>
			</tr>
			
			<c:if test="${not empty requestScope.findpwdMes}">
				<tr>
				<td colspan="2"><div style="color: red">${requestScope.findpwdMes}</div></td>
				</tr>
			</c:if>	
			<%-- <c:if test="${requestScope.findpwdMes eq '验证成功'}">
				<jsp:forward page="changepwd.jsp?id=${requestScope.id}"></jsp:forward>
			</c:if> --%>
			
		</table>
	</form>
</body>
</html>