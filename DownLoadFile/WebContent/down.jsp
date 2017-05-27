<%@ page contentType="text/html;charset=UTF-8"
	import="com.jspsmart.upload.SmartUpload"%>
<%
	String filename = request.getParameter("filename");
	// 新建一个SmartUpload对象
	SmartUpload su = new SmartUpload();
	// 初始化
	//pageContext 页的上下文  ServletContext 应用程序的上下文
	
	su.initialize(pageContext);
	// 设定contentDisposition为null以禁止浏览器自动打开文件，
	//保证点击链接后是下载文件。若不设定，则下载的文件扩展名为doc时，浏览器将自动用word打开它。
	//扩展名为pdf时，浏览器将用acrobat打开。
	su.setContentDisposition(null);
	// 下载文件，保证Web应用下的upload目录下有测试文档.doc文件。
	su.downloadFile("/downFile/" + filename);
	
	//将流清理一下
	out.clear();
	out = pageContext.pushBody();
%>