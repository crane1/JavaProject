package test;

public class TestPeople {

	public static void main(String[] args) {
		People p1 = new Student();
		People p2 = new Teacher();
		
		System.out.println(p1.printInfo());
		System.out.println(p2.printInfo());
		
	}

}
