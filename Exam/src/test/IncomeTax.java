package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IncomeTax {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Employee e = new Employee();
		
		System.out.print("请输入员工的姓名：");
		e.setName(sc.next());
		System.out.print("请输入员工工资：");
		e.setSalary(getInputDoubleNum());
		System.out.print("请输入员工加班补贴：");
		e.setSubsidy(getInputDoubleNum());
		
		e.printEmplyeeInfo();
		
	}
	
	public static double getInputDoubleNum(){
		double str;
		while(true){
			str = 0;
			try{
				str = sc.nextDouble();
				break;
			} catch (InputMismatchException e){
				sc.nextLine();
				System.out.println("输入有误");
			}
		}
		return str;
	}
}
