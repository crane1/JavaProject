package work0426.work010_settest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class MapTest {
	
	public static void main(String[] args) {
		Map<Person, Person> map = null;
		
		
////		1.HashMap验证
//		map = new HashMap<Person, Person>();
//		MapTestMethord.testMap(map, "HashMap");
		
////		//2.TreeMap验证
//		map = new TreeMap<Person, Person>();
//		MapTestMethord.testMap(map, "TreeMap");
		
		map = new Hashtable<Person, Person>();
		MapTestMethord.testMap(map, "Hashtable");
	}
		
		
}
