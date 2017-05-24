package work0426.work010_settest;


import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ListTestMethord {
	public static <T>  void  printlist(List<T> list){
		for(T p : list){
			System.out.println(p);
		}
	}
	
	public static void testList(List<Person> list, String type ){
		Person p1 = new Person("������", 24);
		Person p2 = new Person("��ٻ", 23);
		Person p3 = new Person("���", 23);
		Person p4 = null;   //2.��֤�Ƿ�������nullֵ
		Person p5 = new Person("������", 24);  //3.��֤�Ƿ��������ظ�ֵ����Ҫ����equals��hashcode
		
		Locale l = Locale.ENGLISH;
		
		System.out.println("--------------" + type +"--------------");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4); 
		list.add(p5); 
		
		//1.��֤�Ƿ�����
		System.out.println("����ǰ");
		printlist(list);
		
		
//		2.�Ƿ���sort����,listû��sort����
		list.sort(new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				int flag = 0;
				if(p1 != null && p2 != null){
					flag = p1.getAge() - p2.getAge();
				}else if(p1 == null){
					flag = -1;
				}else if(p2 == null){
					flag = 1;
				}
				return flag;
			}
		});
		
		System.out.println("�����");
		printlist(list);
	}
}
