package work0426.work010_settest;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class setTest {
	
	public static void main(String[] args) {
		Set<Person> set = null;
		
		
		//1.HashSet��֤
//		set = new HashSet<Person>();
//		SetTestMethord.testset(set, "HashSet");
		
		//2.TreeSet��֤
		set = new TreeSet<Person>();
		SetTestMethord.testset(set, "TreeSet");
	}
		
		
}
