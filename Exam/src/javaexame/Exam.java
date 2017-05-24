package javaexame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exam {
	//���ľ���
	public static void printRectangle(int row, int col){
		System.out.println("���ľ���");
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				//����ǵ�һ�к����һ�У���ȫ��
				if(i == 0 || i == row - 1){
					System.out.print("* ");
				}else{
					//����ֻ�����һ�к����һ��
					if(j == 0 || j == col - 1){
						System.out.print("* ");
					}else{
						System.out.print("  ");
					}
				}
			}
			System.out.println();
		}
	}
	
	//��������
	public static void printRhombus(int row) {

		int col = row;
		if (row < 3) {
			System.out.println("�в���̫С�����ܻ�������");
			return;
		}
		System.out.println("��������");
		if (row % 2 == 0) {
			row++;
		}
		if (col % 2 == 0) {
			col++;
		}
		int r_middle = row / 2;
		int c_middle = col / 2;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// ����ǵ�һ�к����һ�У���ֻ���м�һ�����*
				if (i == 0 || i == row - 1) {
					if (j == c_middle) {
						System.out.print("* ");
					} else {
						System.out.print("  ");
					}
				} else {
					// ����ֻ������м���-i���� �� ���м���+i��
					int cur_i = i; // r_middleǰ��
					if (i > r_middle) {
						cur_i = row - 1 - i; // r_middle����
					}
					if (j == c_middle - cur_i || j == c_middle + cur_i) {
						System.out.print("* ");
					} else {
						System.out.print("  ");
					}
				}
			}
			System.out.println();
		}
	}
	
	//ʵ��������
	public static void printTriangle(int row){
		System.out.println("ʵ��������");
		for(int i = 0; i < row; i++){
			for(int j = 0; j <= i; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void get3DivedeNum(int sub, int up){
		for(int i = sub; i <= up; i++){
			if(i % 3 == 0){
				System.out.println(sub +"~" + up + "֮���һ����3���������ǣ�" + i);
				return;
			}
		}
	}
	
	public static void fromDtoE(String path1, String path2){
		String path_src = path1; //"src/����������ңԶ�ľ��롷.txt";
		File f_src = new File(path_src);
		
		
		try {
			if(!f_src.exists()){
				System.out.println("����ļ�����������ңԶ�ľ��롷�����ڵ�ǰsrcĿ¼��");
			}else{
				FileReader fr_src = new FileReader(f_src);
				BufferedReader br_src = new BufferedReader(fr_src);
				
				
				String pathD = path2;
				
				//��src�µ��ļ����Ƶ�pathD��
				File fdD = new File(pathD);
				FileWriter fwD = new FileWriter(fdD);
				BufferedWriter bwD = new BufferedWriter(fwD);
				
				System.out.println("���ڰ� " + path1 + " д�뵽 " + path2 + " ...");
				String str = null;
				while((str = br_src.readLine())!=null){
					bwD.write(str + "\r\n");
					bwD.flush();
				}
				
				br_src.close();
				fr_src.close();
				fwD.close();
				bwD.close();
				Thread.sleep(2000);
				System.out.println("д����ɣ�����");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	
//	7.�����⣺
//	���ӵ�һ��ժ�����ɸ����ӣ���������һ�룬��������ж����һ����
//	�ڶ��������ֽ�ʣ�µ����ӳԵ�һ���ֶ����һ�����Ժ�ÿ�����϶�����ǰһ��ʣ�µ�һ����һ����10���������ڳ�ʱ��
//	��ֻʣ��һ�������ˣ����һ�칲ժ�˶������ӣ�
	
	public static void getPeachNum(int day){
		//���ǿ��԰�ÿ������ӷ�Ϊ�����֣�һ����Ϊһ��+1��һ����Ϊһ��-1��
		//����ʣ���������+1������ԭ�����ӵ�һ�룬�ٳ���2������ǰһ��ʣ�����������
		int sum = 1;
		for(int i = 0; i < day-1; i++){
			sum = (sum+1) * 2;
		}
		System.out.println(sum);
		
	}
	
	public static void main(String[] args) {
////		2.�ֱ��ӡ���ľ��κͿ�������
//		printRectangle(5,15);
//		printRhombus(10);
//		
////		3.��ӡʵ��ֱ��������
//		printTriangle(10);
//		
////		5.���100-200֮���һ����3����������
//		get3DivedeNum(100, 200);
		
//		6.���ļ���D������E��
//		fromDtoE("src/����������ңԶ�ľ��롷.txt", "D:/����������ңԶ�ľ��롷.txt");
//		fromDtoE("D:/����������ңԶ�ľ��롷.txt", "E:/����������ңԶ�ľ��롷.txt");
		
//		7
		getPeachNum(10);
		
	}
}
