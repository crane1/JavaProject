package java06;

public class Book {
	private int number;
	private String name;
	
	public Book(){}
	
	public Book(int number, String name){
		this.number = number;
		this.name = name;
	}
	
	public void borrow(){
		System.out.println("����ķ���");
	}
	
	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book(1, "���μ�");
		b1.name = "��¥��";
		b2.borrow();
	}
}
