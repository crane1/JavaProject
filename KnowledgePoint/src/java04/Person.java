package java04;

public class Person {
	// 1.����
	private String name; 
	private int age;
	
	// 2.����
	public void eat(){
		System.out.println("�һ���׷�");
	}
	
	// 3.���췽��
	public Person(String name){
		this.name = name;
	}
	
	// 4.�ڲ���
	class InnerClass{
		
	}
	
	// 5.��
	static {
		System.out.println("���Ǿ�̬��");
	}
	
	{
		System.out.println("����ʵ����");
	}
}
