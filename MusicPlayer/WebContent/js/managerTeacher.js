//加载完页面后获取班级学员信息
$(function(){
	getClassStudentAll();
})


//获取
function getClassStudentAll() {
	
	var listInfo = "";
	
	//请求所有学生数据
	$.post(
		path + "/getStuData?action=quealclassstudent",
		{},
		function(data) {
			listInfo = "";
			var i = 0;
			listInfo += "<table><caption>班级成员</caption>" + 
				"<td>序号</td><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>电话</td><td>毕业院校</td><td>住址</td><td>邮箱</td><td>身份证</td><td>班长</td><td>操作</td>";
			
			var chats=eval(data);
			if(chats == null){
				listInfo += "<tr><td colspan=\"13\">暂无数据</td></tr></table>";
			}else{
				$.each(chats, function(i,info){
					listInfo += "<tr>" + 
					"<td>" + (i+1) + "</td>" + 
					"<td>" + info.id + "</td>" + 
					"<td>" + info.name + "</td>" + 
					"<td>" + info.sex + "</td>" + 
					"<td>" + info.age + "</td>" + 
					"<td>" + info.tel + "</td>" + 
					"<td>" + info.gradFrom + "</td>" + 
					"<td>" + info.addr + "</td>" + 
					"<td>" + info.email + "</td>" + 
					"<td>" + info.idCard + "</td>" + 
					"<td>" + info.c_monitor + "</td>" + 
					"<td><a href=\""+path+"/getStuData?action=deletestudent&studyid=${clas.id}\" name=\"di\" style=\"display: none;\"> 开除学员</a></td>";
				});
				
				listInfo += 
				"<tr><td ><a href=\"#\" onclick=\"getData('first')\"> 首页</a></td>" +
				"<td ><a href=\"#\" onclick=\"getData('pre')\">上页</a></td>" +
				"<td ><a href=\"#\" onclick=\"getData('nxt')\">下页</a></td>" +
				"<td><a href=\"#\" onclick=\"getData('last')\">尾页</a></td>" +
				"<td colspan=\"8\"><a href=\"#\" onclick=\"getData(getNumber())\">跳到指定页</a><input type=\"number\" id=\"to\">";
				
				listInfo += "</table>";
			}
			$("#info").html(listInfo);
		},
		"JSON"
	);
}
