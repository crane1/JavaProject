package bugcolloct;

import java.util.ArrayList;
import java.util.List;

public class TestBug {
	List<Student> list = new ArrayList<Student>();
	public void printList(){
		System.out.println("----------------");
		for(Student s: list)
			System.out.println(s);
	}
	
	public void addStudent(List<Student> ls){
		for(Student s: ls){
			list.add(s);
		}
	}
	
	public static void main(String[] args) {
		List<Student> s1 = new ArrayList<Student>();
		TestBug tb = new TestBug();
		tb.printList();
		s1.add(new Student("��", 12));
		s1.add(new Student("��", 14));
		s1.add(new Student("��", 15));
		s1.add(new Student("��", 17));
		s1.add(new Student("��", 18));
		
		tb.addStudent(s1);
		tb.printList();
		
		tb.addStudent(s1);
		tb.printList();
	}
}
