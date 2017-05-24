package java05;

public class OutClass {
	private int i = 0;
	
	class InnerClass{
		public void add(){
			i++;
			System.out.println(i);
		}
	}
}
