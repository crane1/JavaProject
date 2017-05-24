package java18;

public class Dog extends Animal{
	public Dog(){}
	public Dog(String name){
		super(name);
	}
	public void watchDoor(){
		System.out.println("狗会看门");
	}
	public void speak(){
		System.out.println("汪汪");
	}
	
	public static void main(String[] args) {
		Dog d = new Dog("花花");
		d.printName();
		d.watchDoor();
		d.speak();
	}
}