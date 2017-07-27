package com.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



public class MyAnnotationController {
	

	public ModelAndView handle(HttpServletRequest req,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("--------------------heheh");
		mav.setViewName("index"); 
		
		return mav;
	}
	
}
