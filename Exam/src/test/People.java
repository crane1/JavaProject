package test;

public class People {
	private String name = "张三";
	private int age = 20;
	
	public People(){}
	public People(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String printInfo(){
		return "姓名：" + name + " 年龄：" + age;
	}
}
