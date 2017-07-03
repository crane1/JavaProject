package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.spring.model.bean.UserInfo;
import com.spring.model.service.IUserInfoService;

public class HelloController extends AbstractController {

	IUserInfoService userService = null;
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		String result = "index";
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if(id == null || id.equals("") || pwd == null || pwd.equals("")){
			mav.addObject("mesg","用户名和密码不能为空");
		}else{
			UserInfo user = null;
			user = userService.checkUserInfo(id, pwd);
			if(user != null){
				List<UserInfo> list = userService.findAllUser();
				req.getSession().setAttribute("userInfo", user);
				result = "success";
				mav.addObject("userList",list);
			}else{
				mav.addObject("mesg","用户名或密码错误");
			}
		}
		
		mav.setViewName(result); // web-inf/jsp/  + hello + .jsp
		
		// 返回model和view
		return mav;
	}
	

	public IUserInfoService getUserService() {
		return userService;
	}

	public void setUserService(IUserInfoService userService) {
		this.userService = userService;
	}
	
	
	
}
