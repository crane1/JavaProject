package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LayerFlowerDetail{
	private static JFrame panel = new JFrame();
	private static Container con = panel.getContentPane();
	private static JLabel pic = new JLabel();
	private static MyLabel name = new MyLabel("花名：",new Font("宋体", Font.BOLD, 12));
	private static MyLabel price = new MyLabel("价格：",new Font("宋体", Font.BOLD, 12));
	private static MyLabel materials = new MyLabel("花材：",new Font("宋体", Font.BOLD, 12));
	private static MyLabel Packages = new MyLabel("包装：",new Font("宋体", Font.BOLD, 12));
	private static MyLabel nums = new MyLabel("数量：",new Font("宋体", Font.BOLD, 12));
	private static MyLabel type = new MyLabel("类型：",new Font("宋体", Font.BOLD, 12));
	private static MyLabel flowerWord = new MyLabel("花语：",new Font("宋体", Font.BOLD, 12));
	private static int isshow = 0;
	public LayerFlowerDetail(){
		con.setBackground(Color.white);
	}
	
	public static void initPanel(){
		panel.pack();
		panel.setVisible(true);
		panel.setLocationRelativeTo(null);
	}
	
	public static void showFlowerInfo(String[] data){
		if (isshow == 0){
			con.add("West", pic);
			JPanel left = new JPanel();
			left.setLayout(new GridLayout(7,1));
			left.add(name);
			left.add(price);
			left.add(materials);
			left.add(Packages);
			left.add(nums);
			left.add(type);
			left.add(flowerWord);
			con.add(left);
			isshow = 1;
		}
		pic.setIcon(new ImageIcon("img/"+ data[0] +".jpg"));
		
		name.getLabel().setText("花名：" + data[1]);
		price.getLabel().setText("价格：" + data[2]);
		materials.getLabel().setText("花材：" + data[3]);
		Packages.getLabel().setText("包装：" + data[4]);
		nums.getLabel().setText("支数：" + data[5]);
		type.getLabel().setText("类型：" + data[6]);
		flowerWord.getLabel().setText("花语：" + data[7]);
		initPanel();
	}
}
