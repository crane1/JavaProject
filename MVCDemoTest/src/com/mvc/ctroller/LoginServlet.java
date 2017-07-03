package com.mvc.ctroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.bean.User;
import com.mvc.model.service.ILoginService;
import com.mvc.model.service.LoginServiceImp;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.set编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2. 获取值
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//3.非空判断
		//先判断ID是否为null，然后在判断equals方法    因为id为null是直接调用equals会报空指针异常
		if(id == null || id.equals("") || pwd == null || pwd.equals("")){
			response.sendRedirect("Login.jsp?mesg=id or pwd not null");
			return;
		}
		
		int iId = -1;
		if(id.matches("^[0-9]+$")){
			iId = Integer.parseInt(id);  //将客户端的获取的id转化为int
		}else{
			response.sendRedirect("Login.jsp?mesg=id is string");
			return;
		}
		
		//4.正确性判断
		ILoginService loginService = new LoginServiceImp();
		
		User user = loginService.checkUserExist(iId, pwd);
		
		if(user != null){
			request.getRequestDispatcher("welcome.jsp").forward(request, response);  //成功登陆的页面跳转
		}else{
			response.sendRedirect("Login.jsp?mesg=id or pwd is false");
			return;
		}
	}
}
