package work0426.work007_right.right;
public class RightTest {
	public int ID;
	protected int age;
	int name;
	private int city;
	
	public int getId(){
		return ID;
	}
	
	protected int getage(){
		return age;
	}
	
	int getname(){
		return name;
	}
	
	private int getcity(){
		return city;
	}
	
	public static void main(String[] args) {
		//本类都可以调到变量
		RightTest rt = new RightTest();
		rt.age = 10;
		rt.city = 10;
		rt.ID = 110;
		rt.name = 10;
		
		rt.getage();
		rt.getcity();
		rt.getId();
		rt.getname();
	}
	

}


