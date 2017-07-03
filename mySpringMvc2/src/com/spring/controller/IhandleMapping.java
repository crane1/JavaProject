package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IhandleMapping {
	String handleMapping(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException;
}
