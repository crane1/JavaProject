package com.javateam1.techonolyshow;

import java.util.Scanner;

public class Main {

	static void runSystem(){
		Scanner input = new Scanner(System.in);	// 初始化输入工具
		Person poet = new Person();	// 创建诗人对象
		
		System.out.println("请输入姓名：");
		poet.setName(input.next());
		System.out.println("欢迎你，" + poet.getName());
		
		while(true){
			System.out.println("请选择服务项：\n1.银行   2.车行");
			System.out.println("输入其他字符结束演示");
			int str = input.nextInt();
			if (str == 1){
				poet.card.runSystem(input);
			} else if(str == 2){
				poet.car.runCarSystem(input, poet);
			} else{
				System.out.println("谢谢惠顾");
				break;
			}
				
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("演示开始\n");
		runSystem();
		System.out.println("\n演示结束");
	}
	
	
}
