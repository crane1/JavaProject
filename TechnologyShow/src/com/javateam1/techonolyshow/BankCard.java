package com.javateam1.techonolyshow;

import java.util.Scanner;

public class BankCard {
	String id;
	double bankBalance;
	double aliBalance;
	
	BankCard(){}
	BankCard(String id){
		this.id = id;
	}
	
	void setId(String id){
		this.id = id;
	}
	
	String getId(){
		return id;
	}
	
	double viewBalance(String position){
		if (position.equals("银行卡")){
			return bankBalance;
		}else{
			return aliBalance;
		}
	}
	
	// 取钱
	boolean withdraw(double cashNum){
		return withdraw(cashNum, "银行卡");
	}
	
	// 取钱
	double minusBalance(double cashNum, double balance){
		balance -= cashNum;
		return balance;
	}
	
	// 取钱
	boolean withdraw(double cashNum, String position){
		System.out.println("取款金额：" + cashNum);
		if(position.equals("银行卡")){
			if (bankBalance < cashNum){
				System.out.println("银行卡余额不足");
				return false;
			}
			bankBalance = minusBalance(cashNum, bankBalance);
		}else{
			if (aliBalance < cashNum){
				System.out.println("支付宝余额不足");
				return false;
			}
			aliBalance = minusBalance(cashNum, aliBalance);
		}
		System.out.println("从" + position + "里面取了" + cashNum + "元");
		return true;
	}
	
	// 存款
	void deposit(double cashNum){
		bankBalance += cashNum;
		System.out.println("\n给银行卡里面存了" + cashNum + "元");
	}
	
	// 存款
	double deposit(double cashNum, double balance){
		balance += cashNum;
		return balance;
	}
	
	// 存款
	void deposit(double cashNum, String position){
		if(position.equals("银行卡")){
			bankBalance = deposit(cashNum, bankBalance);
		}else{
			aliBalance = deposit(cashNum, aliBalance);
		}
		System.out.println("\n给" + position + "里面存了" + cashNum + "元");
	}
	
	// 打印余额
	void printBalance(){
		System.out.println("\n银行卡余额为：" + this.viewBalance("银行卡"));
//		System.out.println("支付宝余额为：" + this.viewBalance("支付宝"));
	}
	
	// 打印卡号
	void printCardId(){
		System.out.println("当前银行卡号为：" + this.getId());
	}
	
	// 运行存取钱系统
	void runSystem(Scanner input){
		if(this.getId() == null){
			System.out.println("请输入银行卡号");
			this.setId(input.next());
		}
		
		this.printCardId();
		while(true){
			System.out.println("欢迎来到银行卡存取钱柜员机\n"
					+ "1.存钱    2.取钱    3.查询余额   4.查询卡号"
					+ "5.退出");
			int inStr = input.nextInt();
			if (inStr == 1){
				System.out.print("请输入存入金额：");
				this.deposit(input.nextDouble());
				continue;
			} else if(inStr == 2){
				System.out.print("请输入取钱金额：");
				this.withdraw(input.nextDouble());
				continue;
			} else if(inStr == 3){
				this.printBalance();
				continue;
			} else if(inStr == 4){
				this.printCardId();
				continue;
			} else if(inStr == 5){
				System.out.println("谢谢惠顾！");
				break;
			}
		}
	}
}
