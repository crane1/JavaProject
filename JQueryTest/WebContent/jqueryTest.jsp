<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function hide(){
		$("p").hide()
		$(".hh").hide()
		$("#hhtitle").hide()
	}
	function show(){
		$("p").show()
		$(".hh").show()
		$("#hhtitle").show()
	}
	function showTime(){
		$("#div1").load("ajaxService.jsp");
	}
	$(document).ready(function(){
		$("p#p3").click(function(){
		    alert("hahahahahha")
		  });
		setInterval("showTime()", 1000)
	})
	
	
</script>
<style >
	div#div1{
		
	}
</style>
</head>
<body>
	<p>我是会隐藏的段落1</p>
	<p>我是会隐藏的段落2</p>
	<p id="p3">我是会隐藏的段落3</p>
	<h1 class="hh">我是会隐藏的h1.hh</h1>
	<h2 id="hhtitle">我是会隐藏的h2.hh</h2>
	<button onclick="hide()">点我隐藏</button>
	<button onclick="show()">点我显示</button>
	<div id="div1"></div>
</body>
</html>