package com.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.UserInfo;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/vip/*" })
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response; 
		HttpSession session = req.getSession();
		UserInfo user = (UserInfo)session.getAttribute("user");
		
		//根据不同用户权限过滤
		if(user == null){
			res.sendRedirect("Fail.jsp");
			return;
		}else{
			StringBuffer url = req.getRequestURL();
			int qx = user.getQx();
			String qx_name = getQXName(qx);
			session.setAttribute("qx_name", qx_name);
			
			int startIndex = url.lastIndexOf("/vip/vip") + 7;
			int req_qx = 0;
			if(startIndex > 0){
				req_qx = Integer.parseInt(url.substring(startIndex+1, startIndex+2));
				String req_qxName = getQXName(req_qx);
				session.setAttribute("req_qxName", req_qxName);
			}
			
			//如果请求的权限大于当前权限，请求失败
			if(req_qx > qx){
				System.out.println("req_qx:" + req_qx + "  qx:" + qx);
				String path = req.getContextPath();
				res.sendRedirect(path + "/Fail.jsp");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public String getQXName(int qx){
		String qx_name = null;
		switch(qx){
		case 0:
			qx_name = "普通";
			break;
		case 1:
			qx_name = "白银";
			break;
		case 2:
			qx_name = "黄金";
			break;
		case 3:
			qx_name = "钻石";
			break;
		case 4:
			qx_name = "至尊";
			break;
		}
		
		return qx_name;
	}
}
