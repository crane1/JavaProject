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
		Person p1 = new Person("李泽明", 24);
		Person p2 = new Person("李倩", 23);
		Person p3 = new Person("李娟", 23);
		Person p4 = null;   //2.验证是否可以添加null值
		Person p5 = new Person("李泽明", 24);  //3.验证是否可以添加重复值，需要重新equals和hashcode
		
		Locale l = Locale.ENGLISH;
		
		System.out.println("--------------" + type +"--------------");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4); 
		list.add(p5); 
		
		//1.验证是否有序
		System.out.println("排序前");
		printlist(list);
		
		
//		2.是否有sort方法,list没有sort方法
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
		
		System.out.println("排序后");
		printlist(list);
	}
}
