package com.javateam1.flowerstore.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDemo extends JPanel{
	private MyLabel title;
	private JPanel center;
	private JPanel bottom;
	private MyButton fore, back;
	
	public PanelDemo(String name, String[] data){
		title = new MyLabel(name,new Font("宋体", Font.BOLD, 20));
		bottom = new JPanel();
		bottom.setBackground(Color.white);
		
		center = new JPanel();
		center.setLayout(new FlowLayout(0, 40, 20));
		center.setBackground(Color.white);
		
//		list.add(f.getId());
//		list.add(f.getName());
//		list.add(String.valueOf(f.getPrice()));
//		list.add(f.getMaterials());
//		list.add(f.getPackages());
//		list.add(String.valueOf(f.getNum()));
//		list.add(f.getType());
//		list.add(f.getFlowerWord());
		for (int i = 2; i < data.length; i+=8){
			String fpath = "img/"+ data[i] +".jpg";
			String fname = data[i + 2];
			double fprice = Double.valueOf(data[i + 2]);
			FlowerInfo flowrInfo = new FlowerInfo(fpath, fname, fprice);
			center.add(flowrInfo);
		}

		fore = new MyButton("上一页");
		back = new MyButton("下一页");
		
		initPanel();
	}
	
	public void initPanel(){
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.add("North", title);
		this.add("Center",center);
		bottom.add(fore);
		bottom.add(back);
		this.add("South", bottom);
	}
	
	public static void main(String[] args) {
	}
	
}
