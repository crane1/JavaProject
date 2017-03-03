package com.javateam1.restuarant.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.javateam1.restuarant.control.AccountManager;
import com.javateam1.restuarant.control.FoodManager;
import com.javateam1.restuarant.control.RestaurantManager;
import com.javateam1.restuarant.control.OrderManager;
import com.javateam1.restuarant.model.*;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	Restaurant rest = new Restaurant();
	AccountManager accountarray = new AccountManager();
	RestaurantManager manager = new RestaurantManager();
	FoodManager foodlist = rest.getFoodlist();
	OrderManager orders = rest.getOrders();
	
	public void printMain(){
		while(true){
			System.out.println("\n**************欢迎来到Team1餐馆****************");
			System.out.println("请选择服务内容");
			System.out.println("1.普通用户登录\n2.管理员登录\n3.查看菜单\n4.用户注册\n5.退出");
			System.out.print("#:");
			int str = getInputIntNum();
			switch(str){
			case 1: 
				Account customer = accountarray.signIn(0);
				if( customer != null){
					printCustomerMenu(customer);
				}
				break;
			case 2:
				RestaurantManager manager =  (RestaurantManager) accountarray.signIn(1);
				if( manager != null){
					printManagerMenu(manager);
				}
				break;
			case 3:
				foodlist.printList();
				break;
			case 4:
				accountarray.addAccount();
				break;
			case 5:
				System.out.println("谢谢惠顾");
				System.exit(0);
				break;
			case 10:
				accountarray.printAccountArray();
				break;
			default:
				System.out.println("输入有误");
			}
		}
	}
	
	public void printManagerMenu(RestaurantManager manager){
//		j.修改菜单内容（增添菜） 查询账户余额， 查询全部订单内容 ，删除订单
		while(true){
			System.out.println("\n1.修改菜单内容 2.查询账户余额 3.查询全部订单内容   4.删除订单 0.退出");
			System.out.print("#:");
			int str = getInputIntNum();
			
			if (str == 0){
				break;
			}
			switch(str){
			case 1:
				manager.printModifyFoodlist(foodlist);
				break;
			case 2:
				manager.viewBalance();
				break;
			case 3:
				manager.printAllOrder(orders);
				break;
			case 4:
				manager.deleteOrder(orders);
			default:
				System.out.println("输入有误");
				break;
			}
		}
	}
	
	public void printCustomerMenu(Account account){
//		i.点餐 查询自己的订单（可选） 查询自己的支出信息（可选）
		while(true){
			System.out.println("\n1.点餐 2.查看自己的订单 3.支付账单 4.充值 5.查询余额  6.删除订单 0.退出");
			System.out.print("#:");
			int str = getInputIntNum();
			if (str == 0){
				break;
			}
			switch(str){
			case 1:
				account.order(foodlist,rest);
				break;
			case 2:
				account.printOrderInfo();
				break;
			case 3:
				account.payOrder();
				break;
			case 4:
				account.recharge();
				break;
			case 5:
				account.viewBalance();
				break;
			case 6:
				account.deletOrder();
				break;
			default:
				System.out.println("输入有误");
				break;
			}
		}
	}
	
	public static int getInputIntNum(){
		int str;
		while(true){
			str = 0;
			try{
				str = sc.nextInt();
//				System.out.println("haohaoh");
				break;
			} catch (InputMismatchException e){
				sc.nextLine();
				System.out.println("输入有误");
			}
		}
		return str;
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
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.printMain();
		System.out.println(Menu.getInputIntNum());
	}
	
}
