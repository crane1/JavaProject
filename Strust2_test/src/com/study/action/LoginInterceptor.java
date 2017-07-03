package com.study.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	@Override
	public void destroy() {
		System.out.println("LoginInterceptor------------------destroy:");
		
	}

	@Override
	public void init() {
		System.out.println("LoginInterceptor------------------init:");
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String user = (String)arg0.getInvocationContext().getSession().get("stuInfo");
		System.out.println("LoginInterceptor------------------intercept1:" + user);
		arg0.invoke();
		user = (String)arg0.getInvocationContext().getSession().get("stuInfo");
		System.out.println("LoginInterceptor------------------intercept2:" + user);
		return null;
	}

}
