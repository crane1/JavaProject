package work0426.work010_settest;

import java.util.Map;
import java.util.Set;

public class MapTestMethord {
	public static  void  printset(Map<Person, Person> map){
		Set<Person> keySet = map.keySet();
		for(Person p : keySet){
			System.out.println(p + ": " + map.get(p));
		}
	}
	
	public static void testMap(Map<Person, Person> map, String type ){
		
		for(int i = 10; i >= 0; i--){
			Person p = new Person("������" + i, i);
			map.put(p,p);
		}
		
		Person p1 = null;   //2.��֤�Ƿ�������nullֵ
		Person p2 = new Person("������11", 11);  //3.��֤�Ƿ��������ظ�ֵ����Ҫ����equals��hashcode
		Person p3 = new Person("������1", 1);
		
		System.out.println("--------------" + type +"--------------");
		
		map.put(p2, p2);
		map.put(p2, p3);
		
		//1.��֤�Ƿ�����
		System.out.println("����ǰ");
		printset(map);
		
		//2.�Ƿ���sort����,mapû��sort�������޷�����
//		map.sort(new Comparator<Person>() {
//
//			@Override
//			public int compare(Person p1, Person p2) {
//				int flag = 0;
//				if(p1 != null && p2 != null){
//					flag = p1.getAge() - p2.getAge();
//				}else if(p1 == null){
//					flag = -1;
//				}else if(p2 == null){
//					flag = 1;
//				}
//				return flag;
//			}
//		});
//		
//		System.out.println("�����");
//		printset(set);
	}
}
