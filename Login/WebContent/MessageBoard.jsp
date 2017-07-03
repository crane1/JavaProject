
<%@page import="java.util.Random"%>
<%@page import="com.study.mvc.tools.DBUtil"%>
<%@page import="com.study.mvc.model.bean.Message"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="com.study.mvc.model.bean.UserInfo"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>留言板</title>
        <link rel="stylesheet" href="css/bg.css" />
        <link rel="stylesheet" href="css/meg_board.css" />
    </head>
    <body>
    	<div id="layer1" >
    		<img src="img/bg1.jpg" width="100%" height="100%"/>
    	</div>
    	<%
    	//获取当前用户
		UserInfo cur_user = (UserInfo)session.getAttribute("user");
    	%>
    	<div style="text-align: center">
    		<%=cur_user.getName() %><a href="Loginout.jsp">注销</a>
    		<a href="welcome.jsp">在线列表</a>
    	
    	</div><br><br>
    	
    	<div id="out_box" class="bor_col">
    		<div id="title" class="t_head">留言板</div>
    		<hr class="bor_col"/>
    		
    		<!--
    		<div class="context t_head">版主寄语</div>
    		<hr class="bor_col"/>
    		
    		<div class="context"><textarea  name="host_mes" class="in_mes" value="">版主很懒，没留下什么</textarea></div>
    		-->
    		<!--留言表单-->
    		<form action="MesgServlet" method="post" >
    			<div class="bor_col" id="t_form">
    				<br />
	    			<div class="context t_head">发表你的留言</div>
	    			<hr class="bor_col"/>
	    			<div class="context"><textarea name="guest_mes" class="in_mes">怎么样，近来安好</textarea></div>
	    			<div class="context"><input type="submit" value="发表" id="submit"/></div><br>
    			</div>
    		</form><br />
    		
    		<%	
			
			
			@SuppressWarnings("unchecked")
			List<Message> list = (List<Message>)application.getAttribute("Message");
			
			
			if(list != null && list.size() > 0){
				out.write("<div class='context t_head'>留言(" + list.size() + ")</div>");
				out.write("<hr class='bor_col'/>");
				
				DBUtil util = DBUtil.getInstance();
				
				for(int i = list.size(); i > 0; i--){
					
					Message mes = list.get(i-1);
					out.write("<div class='part'>");
					out.write("<div class='context'><img src='img/pic"+ mes.getUserId() +".jpg' class='photo '></div>");
					
					if(mes.getUserId() == cur_user.getId()){
						out.write("<div class='context p_name' >" + mes.getUserName() + "(" + mes.getUserId() + " 我)" + " <span class='floor'>第" + mes.getMesId() + "楼</span></div>");
					}else{
						out.write("<div class='context p_name' >" + mes.getUserName() + "(" + mes.getUserId() + ")" + " <span class='floor'>第" + mes.getMesId() + "楼</span></div>");
					}
					
					out.write("<div class='context mesg'>"+mes.getMesg()+"</div>");
					out.write("</div>");
					out.write("<hr class='bor_col'/>");
				}
			}else{
				out.write("<div class='context t_head'>留言(0)</div>");
				out.write("<hr class='bor_col'/>");
			}
			
			String succ_mes = (String)session.getAttribute("succ_mes");
			session.setAttribute("succ_mes", null);
			
			%>
    	</div>
    	<script type="text/javascript">
    		var promt =  '<%=succ_mes%>'
    		if(promt != "null" && promt != "" ){
    			alert(promt);
    			promt = "";
    		}
    	</script>
 	</body>
</html>