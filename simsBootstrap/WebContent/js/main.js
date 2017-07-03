window.onload=function(){
	var total = document.documentElement.clientHeight;
	document.getElementById("outer").style.height=total*0.97+"px";
	
	document.getElementsByTagName("li")
	for(var i = 1; i <= 8; i++){
		var li = document.getElementById("li_" + i);
		if(li != null){
			document.getElementById("li_" + i).onmouseover = function(){
				this.style.backgroundColor = "cadetblue";
				this.style.color = "white"
			}
			document.getElementById("li_" + i).onmouseout = function(){
				this.style.backgroundColor = "cornflowerblue";
				this.style.color = "white"
			}
		}
	}
	
	var show = document.getElementById("show_info");   //展示区
	var inner = document.getElementById("inner_navig");  //内导航区
	
	var show_height = show.offsetHeight;  //展示区高度
	var inner_height = inner.offsetHeight;  //内导航区高度
	
	 //如果展示区高度大于内导航区，那么内导航区高度与展示区高度保持一致
	if(show_height > inner_height){ 
		inner.style.height = show_height + "px";
	}else{
		show.style.height = inner_height + "px";
	}
	
	document.getElementById("show_info").align = "center";
}