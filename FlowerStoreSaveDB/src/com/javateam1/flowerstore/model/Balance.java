package com.javateam1.flowerstore.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.javateam1.flowerstore.dao.AccountDao;
import com.javateam1.flwoerstore.control.AccountManager;

public class Balance {
	String user_id;
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
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		System.out.println("setuer_id:" + user_id);
		this.user_id = user_id;
	}
	public void viewBalance(){
		System.out.println("账户余额：" + formateNum(balance));
	}
	
	public void deposite(double num){
		balance += num;
		String log = "收入：" + formateNum(num) + "元\t余额：" + formateNum(balance) + "\n";
		addExpenseLog(log);
		saveBalance();
	}
	
	public boolean withDraw(double num){
		if (balance >= num){
			balance -= num;
			String log = "支出：" + formateNum(num) + "元\t余额：" + formateNum(balance) + "\n";
			addExpenseLog(log);
			saveBalance();
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
	
	public void saveBalance(){
		Account a;
		try {
			a = AccountManager.findAccountById(user_id);
			AccountDao.updateAccount(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
