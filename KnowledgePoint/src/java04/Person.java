package java04;

public class Person {
	// 1.属性
	private String name; 
	private int age;
	
	// 2.方法
	public void eat(){
		System.out.println("我会吃米饭");
	}
	
	// 3.构造方法
	public Person(String name){
		this.name = name;
	}
	
	// 4.内部类
	class InnerClass{
		
	}
	
	// 5.块
	static {
		System.out.println("我是静态块");
	}
	
	{
		System.out.println("我是实例块");
	}
}
