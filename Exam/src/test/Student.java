package test;

public class Student extends People {
	private String sno = "111004109";
	
	public Student(){}
	public Student(String name, int age, String sno){
		super(name, age);
		this.sno = sno;
	}
	
	public String printInfo(){
		return super.printInfo() + " Ñ§ºÅ£º" + sno;
	}
	
}
