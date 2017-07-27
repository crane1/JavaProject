package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MyModelAndDriven extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView();
//		model.setViewName("redirect:/hello.action?method=handle&id=1&pwd=123");
		model.setViewName("forward:/hello.action?method=handle");
		return model;
	}


}
