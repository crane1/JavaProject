package work0426.work007_right.right;

public class Test {
	public static void main(String[] args) {
		//ͬ���µ�������
		RightTest rt = new RightTest();
		rt.age = 10;
//		rt.city = 10;  //private������
		rt.ID = 110;
		rt.name = 10;
		
		rt.getage();
//		rt.getcity(); //private������
		rt.getId();
		rt.getname();
	}
}

class subRightTest extends RightTest{
	public static void main(String[] args) {
		// ͬ���µ�����
		RightTest rt = new RightTest();
		rt.age = 10;
//		rt.city = 10;  //private������
		rt.ID = 110;
		rt.name = 10;
		
		rt.getage();
//		rt.getcity(); //private������
		rt.getId();
		rt.getname();
	}
}
