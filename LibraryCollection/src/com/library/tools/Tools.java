package com.library.tools;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Tools {
	private final static Scanner sc = new Scanner(System.in);
	private final static boolean ISNEED = true;  // �������ο����е�״̬��������Ϊfalse�������Σ�trueΪ�ſ�
	private static Locale currentLocal = null;  //��ǰlocal
	private static ResourceBundle myResource= null;  //���ռ��ص�������Դ�ļ�
	
	/**
	 * 
	 * �������� initResourse ��ʼ�������Դ<br>
	 * ����˵�������ݲ�ͬ����������Ӧ�����ļ�<br>
	 */
	public static void initResourse(){
		currentLocal = Locale.getDefault();
		myResource = ResourceBundle.getBundle("com.library.resource.messageResource", currentLocal);
	}
	
	private static void checkExitSystem(String value){
		//���������ط�����"exit"�� ��ϵͳֱ���˳�
		if(value.equals("exit")){
			System.out.println("����ǿ���˳�");
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * �������� getInputString  ��ȡһ���ַ�������
	 * ����˵���� ����һ����ʾ�����ӡ��Ȼ��Ӽ��̻�ȡһ���ַ�������
	 * @param promptMessage ��ʾ��
	 *
	 * @return ���شӼ��̽��յ����ַ���
	 */
	public static String getInputString(String promptMessage){
		printContent(promptMessage);
		String value = sc.nextLine();
		checkExitSystem(value);
		return value;
	}
	
	/**
	 * 
	 * �������� getInputInt  ��ȡһ����������
	 * ����˵����  ����һ����ʾ�����ӡ��Ȼ��Ӽ��̻�ȡһ���ַ������룬��ʹ��������ʽ���ж��Ƿ�������
	 *        ����ǣ���ת��Ϊ����������������ѭ����ȡ
	 * @param promptMessage ��ʾ��
	 *
	 * @return ���شӼ��̽��յ�������
	 */
	public static String getInputInt(String promptMessage){
		String str = null;  // ����������ַ�
		printContent(promptMessage);
		while(true){
			str = sc.nextLine();
			checkExitSystem(str);
			if (str.matches("^[0-9]+$") || str.equals("back")){
				break;
			} else{
				System.out.println("���벻ƥ�䣬����������:");
			}
		}
		return str;  //����ʱ���ֵ��ַ���
	}
	
	public static boolean isBack(String str){
		return str.equals("back");
	}
	
	/**
	 * 
	 * �������� printContent ��ӡϵͳ�����԰�
	 * ����˵���� ��ӡ��Ҫ��ϵͳ�����û��������ַ���
	 * @param str ��Ҫת����ӡ���ַ���ֵ
	 */
	public static void printContent(String str){
		String value = myResource.getString(str);
		System.out.println(value);
	}
	
	/**
	 * 
	 * �������� printContent ��ӡϵͳ����Ҫ��������
	 * ����˵���� ��ӡ��Ҫ��ϵͳ�����û��������ַ���
	 * @param str ��Ҫ��ӡ���ַ�
	 */
	public static void printContent2(String str){
		System.out.println(str);
	}
	
	/**
	 * 
	 * �������� printComment ��ӡ����������Ҫ�鿴��״̬���
	 * ����˵���� ��ӡ����Ҫ��ϵͳ�����û��������ַ�����ֻ�𵽸�������������
	 * @param str ��Ҫ��ӡ���ַ�
	 */
	public static void printComment(String str){
		if(ISNEED){
			System.out.println(str);
		}
	}
		
}
