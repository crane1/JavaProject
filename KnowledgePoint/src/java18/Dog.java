package java18;

public class Dog extends Animal{
	public Dog(){}
	public Dog(String name){
		super(name);
	}
	public void watchDoor(){
		System.out.println("���ῴ��");
	}
	public void speak(){
		System.out.println("����");
	}
	
	public static void main(String[] args) {
		Dog d = new Dog("����");
		d.printName();
		d.watchDoor();
		d.speak();
	}
}