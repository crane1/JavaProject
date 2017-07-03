package com.library.tools;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Tools {
	private final static Scanner sc = new Scanner(System.in);
	private final static boolean ISNEED = true;  // 用于屏蔽开发中的状态输出，如果为false就是屏蔽，true为放开
	private static Locale currentLocal = null;  //当前local
	private static ResourceBundle myResource= null;  //接收加载的语言资源文件
	
	/**
	 * 
	 * 方法名： initResourse 初始化相关资源<br>
	 * 功能说明：根据不同地区加载相应语言文件<br>
	 */
	public static void initResourse(){
		currentLocal = Locale.getDefault();
		myResource = ResourceBundle.getBundle("com.library.resource.messageResource", currentLocal);
	}
	
	private static void checkExitSystem(String value){
		//如果在任意地方输入"exit"， 则系统直接退出
		if(value.equals("exit")){
			System.out.println("程序强制退出");
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * 方法名： getInputString  获取一个字符串输入
	 * 功能说明： 接收一个提示语，并打印，然后从键盘获取一个字符串输入
	 * @param promptMessage 提示语
	 *
	 * @return 返回从键盘接收到的字符串
	 */
	public static String getInputString(String promptMessage){
		printContent(promptMessage);
		String value = sc.nextLine();
		checkExitSystem(value);
		return value;
	}
	
	/**
	 * 
	 * 方法名： getInputInt  获取一个整型输入
	 * 功能说明：  接收一个提示语，并打印，然后从键盘获取一行字符串输入，并使用正则表达式来判断是否是数字
	 *        如果是，则转换为整型输出，否则继续循环获取
	 * @param promptMessage 提示语
	 *
	 * @return 返回从键盘接收到的整型
	 */
	public static String getInputInt(String promptMessage){
		String str = null;  // 接收输入的字符
		printContent(promptMessage);
		while(true){
			str = sc.nextLine();
			checkExitSystem(str);
			if (str.matches("^[0-9]+$") || str.equals("back")){
				break;
			} else{
				System.out.println("输入不匹配，请重新输入:");
			}
		}
		return str;  //返回时数字的字符串
	}
	
	public static boolean isBack(String str){
		return str.equals("back");
	}
	
	/**
	 * 
	 * 方法名： printContent 打印系统中语言包
	 * 功能说明： 打印需要在系统中与用户交互的字符串
	 * @param str 需要转换打印的字符键值
	 */
	public static void printContent(String str){
		String value = myResource.getString(str);
		System.out.println(value);
	}
	
	/**
	 * 
	 * 方法名： printContent 打印系统中需要输出的语句
	 * 功能说明： 打印需要在系统中与用户交互的字符串
	 * @param str 需要打印的字符
	 */
	public static void printContent2(String str){
		System.out.println(str);
	}
	
	/**
	 * 
	 * 方法名： printComment 打印开发当中需要查看的状态语句
	 * 功能说明： 打印不需要在系统中与用户交互的字符串，只起到辅助开发的作用
	 * @param str 需要打印的字符
	 */
	public static void printComment(String str){
		if(ISNEED){
			System.out.println(str);
		}
	}
		
}
