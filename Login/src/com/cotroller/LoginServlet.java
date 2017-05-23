package com.cotroller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DBUtil;
import com.model.UserInfo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		boolean remember = Boolean.parseBoolean(request.getParameter("remember"));
		
		//验证id和密码是否为空
		if(id == null || id == ""){
			response.sendRedirect("Login.jsp?error=id_empty");
			return;
		}
		
		if(pwd == null || pwd == ""){
			response.sendRedirect("Login.jsp?error=pwd_empty");
			return;
		}
		
		DBUtil dbutil = DBUtil.getInstance();
		int a = Integer.parseInt(id);
		UserInfo user = dbutil.queryUser(a, pwd);
		
		//如果id和密码都不为空
		if(user != null){
			//如果记住密码，则设置cookie
			if(remember){
				Cookie c_id = new Cookie("id", id);
				Cookie c_pwd = new Cookie("pwd", pwd);
			        
			    //设置过期时间 10天
				c_id.setMaxAge(10*24*60*60);
				c_pwd.setMaxAge(10*24*60*60);
			        
			    //存储
			    response.addCookie(c_id);
			    response.addCookie(c_pwd);
			}else{
				Cookie c_id = new Cookie("id", null);  //删除名称为id的Cookie
				Cookie c_pwd = new Cookie("pwd", null);

				c_id.setMaxAge(0); //立即删除型
				c_pwd.setMaxAge(0);

				 //覆盖
			    response.addCookie(c_id);
			    response.addCookie(c_pwd); //重新写入，将覆盖之前的
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			//记录在线用户
			 ServletContext app = getServletContext();
			System.out.println("---------------追加元素开始");
			
			@SuppressWarnings("unchecked")
			Set<UserInfo> set = (Set<UserInfo>)app.getAttribute("userSet");
			
			if(set == null ){
				set = new HashSet<UserInfo>();
			}
			
			System.out.println("------------添加了");
			set.add(user);
			app.setAttribute("userSet", set);
			System.out.println("size: " + set.size());
			
			
			System.out.println("---------------追加元素结束");
		    request.getRequestDispatcher("welcome.jsp").forward(request, response);
			return;
		}else{
			response.sendRedirect("Login.jsp?error=error");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
