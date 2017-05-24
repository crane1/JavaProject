package test;

public class Teacher extends People {
	private double salary = 20000;
	
	public Teacher(){}
	public Teacher(String name, int age, double salary){
		super(name, age);
		this.salary = salary;
	}
	
	public String printInfo(){
		return super.printInfo() + " ¹¤×Ê£º" + salary;
	}
}
