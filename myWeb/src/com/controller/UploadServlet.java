package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.UserInfo;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath=this.getServletContext().getRealPath("/upfile/");
		System.out.println(savePath);
		MultipartRequest multi=
		                new MultipartRequest(request,savePath,50*1024*1024);
		//传回所有文件输入类型的名称   
		Enumeration files = multi.getFileNames();   
		String fileType = "";   
		String fileName="";   
		while (files.hasMoreElements()) {   
			fileType = (String) files.nextElement();   
			fileName = multi.getFilesystemName(fileType);
			
			File f = multi.getFile(fileType);   
			if (null == f) {
				throw new ServletException("file is not exist");   
			}else{
				String path = request.getContextPath()+"/upfile/" + f.getName();
				System.out.println("path"+path);
				HttpSession session = request.getSession();
				UserInfo user = (UserInfo)session.getAttribute("user");
				user.setProtrait(path);
				response.sendRedirect("welcome.jsp");
			}
			
		}
	}

}
