package com.study.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.study.medol.bean.Student;
import com.study.medol.dao.IStudentService;

public class RegisterAction extends ActionSupport implements ModelDriven<Student> {
	private static final long serialVersionUID = 1L;
	
	private IStudentService stuService;
	private Student stu = new Student();
	
	@Override
	public String execute() throws Exception {
		System.out.println("stu- execute----" + stu);
		int res = stuService.addStudent(stu);
		System.out.println("res------------" + res);
		if(res > 0){
			addActionMessage("×¢²á³É¹¦");
			System.out.println("×¢²á³É¹¦");
		}else{
			addActionMessage("×¢²áÊ§°Ü");
			System.out.println("×¢²áÊ§°Ü");
			return LOGIN;
		}
		return SUCCESS;
	}

	@Override
	public Student getModel() {
		return this.stu;
	}

	public IStudentService getStuService() {
		return stuService;
	}

	public void setStuService(IStudentService stuService) {
		this.stuService = stuService;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}
	
}
