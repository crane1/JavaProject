package test;

public class People {
	private String name = "����";
	private int age = 20;
	
	public People(){}
	public People(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String printInfo(){
		return "������" + name + " ���䣺" + age;
	}
}
