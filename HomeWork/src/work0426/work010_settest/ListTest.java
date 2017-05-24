package work0426.work010_settest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


public class ListTest {
	
	public static void main(String[] args) {
		List<Person> list = null;
		
		
		//1.ArrayList验证
		list = new ArrayList<Person>();
		ListTestMethord.testList(list, "ArrayList");
		
		//2.LinkList验证
		list = new LinkedList<Person>();
		ListTestMethord.testList(list, "LinkedList");
		
		//3.Vector验证
		list = new Vector<Person>();
		ListTestMethord.testList(list, "Vector");
	}
		
		
}
