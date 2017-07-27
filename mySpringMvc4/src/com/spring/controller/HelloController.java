package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.model.bean.UserInfo;
import com.spring.model.service.IUserInfoService;

public class HelloController extends MultiActionController {

	IUserInfoService userService = null;
	
	public ModelAndView handle(HttpServletRequest req,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String result = "index";
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println("id:-----------" + id);
		System.out.println("pwd:-----------" + pwd);
		
		if(id == null || id.equals("") || pwd == null || pwd.equals("")){
			mav.addObject("mesg","�û��������벻��Ϊ��");
		}else{
			UserInfo user = null;
			user = userService.checkUserInfo(id, pwd);
			if(user != null){
				List<UserInfo> list = userService.findAllUser();
				req.getSession().setAttribute("userInfo", user);
				result = "success";
				mav.addObject("userList",list);
			}else{
				mav.addObject("mesg","�û������������");
			}
		}
		
		mav.setViewName(result); // web-inf/jsp/  + hello + .jsp
		
		// ����model��view
		return mav;
	}
	
	public ModelAndView hello(HttpServletRequest req,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println("hello--------------");
		mav.setViewName("success");
		return mav;
	}
	

	public IUserInfoService getUserService() {
		return userService;
	}

	public void setUserService(IUserInfoService userService) {
		this.userService = userService;
	}
	
	
	
}