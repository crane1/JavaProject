package com.javateam1.restuarant.model;

public class Balance {
	double balance;
	StringBuffer expenseLog;
	
	public Balance(){
		balance = 0;
		expenseLog = new StringBuffer("");
	}
	public Balance(int balance){
		this.balance = balance;
		expenseLog = new StringBuffer("");
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public StringBuffer getExpenseLog() {
		return expenseLog;
	}
	public void setExpenseLog(StringBuffer expenseLog) {
		this.expenseLog = expenseLog;
	}
	
	public void viewBalance(){
		System.out.println("账户余额：" + formateNum(balance));
	}
	
	public void deposite(double num){
		balance += num;
		String log = "收入：" + formateNum(num) + "元\t余额：" + formateNum(balance) + "\n";
		addExpenseLog(log);
	}
	
	public boolean withDraw(double num){
		if (balance >= num){
			balance -= num;
			String log = "支出：" + formateNum(num) + "元\t余额：" + formateNum(balance) + "\n";
			addExpenseLog(log);
			return true;
		} else {
			System.out.println("余额不足");
			return false;
		}
		
	}
	
	public void printExpenseLog(){
		System.out.println("*******消费记录*********************");
		System.out.println(expenseLog);
		System.out.println("**********************************");
		
	}
	
	public void addExpenseLog(String log){
		expenseLog.append(log);
	}
	
	public String formateNum(double num){
		return String.format("%.2f", num);
	}
	public static void main(String[] args) {
		Balance b = new Balance();
		b.deposite(10000.87);
		b.viewBalance();
		b.withDraw(233.89);
		b.viewBalance();
		b.printExpenseLog();
	}
}
