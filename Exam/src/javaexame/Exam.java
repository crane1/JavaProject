package javaexame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exam {
	//空心矩形
	public static void printRectangle(int row, int col){
		System.out.println("空心矩形");
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				//如果是第一行和最后一行，则全输
				if(i == 0 || i == row - 1){
					System.out.print("* ");
				}else{
					//否则，只输出第一列和最后一列
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
	
	//空心菱形
	public static void printRhombus(int row) {

		int col = row;
		if (row < 3) {
			System.out.println("行参数太小，不能绘制菱形");
			return;
		}
		System.out.println("空心菱形");
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
				// 如果是第一行和最后一行，则只在中间一列输出*
				if (i == 0 || i == row - 1) {
					if (j == c_middle) {
						System.out.print("* ");
					} else {
						System.out.print("  ");
					}
				} else {
					// 否则，只输出（中间列-i）列 和 （中间列+i）
					int cur_i = i; // r_middle前行
					if (i > r_middle) {
						cur_i = row - 1 - i; // r_middle后行
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
	
	//实心三角形
	public static void printTriangle(int row){
		System.out.println("实心三角形");
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
				System.out.println(sub +"~" + up + "之间第一个被3整除的数是：" + i);
				return;
			}
		}
	}
	
	public static void fromDtoE(String path1, String path2){
		String path_src = path1; //"src/《世界上最遥远的距离》.txt";
		File f_src = new File(path_src);
		
		
		try {
			if(!f_src.exists()){
				System.out.println("请把文件《世界上最遥远的距离》放置在当前src目录下");
			}else{
				FileReader fr_src = new FileReader(f_src);
				BufferedReader br_src = new BufferedReader(fr_src);
				
				
				String pathD = path2;
				
				//将src下的文件复制到pathD里
				File fdD = new File(pathD);
				FileWriter fwD = new FileWriter(fdD);
				BufferedWriter bwD = new BufferedWriter(fwD);
				
				System.out.println("正在把 " + path1 + " 写入到 " + path2 + " ...");
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
				System.out.println("写入完成！！！");
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
//	7.附加题：
//	猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾有多吃了一个，
//	第二天早上又将剩下的桃子吃掉一半又多吃了一个，以后每天早上都吃了前一天剩下的一半零一个第10天早上想在吃时，
//	就只剩下一个桃子了，求第一天共摘了多少桃子？
	
	public static void getPeachNum(int day){
		//我们可以把每天的桃子分为两部分：一部分为一半+1，一部分为一半-1；
		//所以剩余的桃子数+1，即是原来桃子的一半，再乘以2，就是前一天剩余的桃子数。
		int sum = 1;
		for(int i = 0; i < day-1; i++){
			sum = (sum+1) * 2;
		}
		System.out.println(sum);
		
	}
	
	public static void main(String[] args) {
////		2.分别打印空心矩形和空心菱形
//		printRectangle(5,15);
//		printRhombus(10);
//		
////		3.打印实心直角三角形
//		printTriangle(10);
//		
////		5.求出100-200之间第一个被3整除的数：
//		get3DivedeNum(100, 200);
		
//		6.把文件从D盘流到E盘
//		fromDtoE("src/《世界上最遥远的距离》.txt", "D:/《世界上最遥远的距离》.txt");
//		fromDtoE("D:/《世界上最遥远的距离》.txt", "E:/《世界上最遥远的距离》.txt");
		
//		7
		getPeachNum(10);
		
	}
}
