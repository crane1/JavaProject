package work0426.work010_settest;

import java.util.Set;

public class SetTestMethord {
	public static <T>  void  printset(Set<T> set){
		for(T p : set){
			System.out.println(p);
		}
	}
	
	public static void testset(Set<Person> set, String type ){
		
		for(int i = 1000; i >= 0; i--){
			Person p = new Person("李泽明" + i, i);
			set.add(p);
		}
		
		Person p1 = null;   //2.验证是否可以添加null值
		Person p2 = new Person("李泽明1", 1);  //3.验证是否可以添加重复值，需要重新equals和hashcode
		
		
		System.out.println("--------------" + type +"--------------");
		
//		set.add(p1);
		set.add(p2);
		
		//1.验证是否有序
		System.out.println("排序前");
		printset(set);
		
		//2.是否有sort方法,Set没有sort方法，无法排序
//		set.sort(new Comparator<Person>() {
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
//		System.out.println("排序后");
//		printset(set);
	}
}
