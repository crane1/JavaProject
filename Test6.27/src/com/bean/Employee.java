package com.bean;

public class Employee {
	private int empon;
	private String name;
	private double salary;
	private int age;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empon, String name, double salary, int age) {
		super();
		this.empon = empon;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	public int getEmpon() {
		return empon;
	}
	public void setEmpon(int empon) {
		this.empon = empon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
