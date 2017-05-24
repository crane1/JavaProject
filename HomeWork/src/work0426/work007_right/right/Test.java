package work0426.work007_right.right;

public class Test {
	public static void main(String[] args) {
		//同包下的其他类
		RightTest rt = new RightTest();
		rt.age = 10;
//		rt.city = 10;  //private调不到
		rt.ID = 110;
		rt.name = 10;
		
		rt.getage();
//		rt.getcity(); //private调不到
		rt.getId();
		rt.getname();
	}
}

class subRightTest extends RightTest{
	public static void main(String[] args) {
		// 同包下的子类
		RightTest rt = new RightTest();
		rt.age = 10;
//		rt.city = 10;  //private调不到
		rt.ID = 110;
		rt.name = 10;
		
		rt.getage();
//		rt.getcity(); //private调不到
		rt.getId();
		rt.getname();
	}
}
