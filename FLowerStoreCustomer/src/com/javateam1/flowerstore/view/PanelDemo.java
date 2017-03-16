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
	
	public PanelDemo(String name){
		title = new MyLabel(name,new Font("宋体", Font.BOLD, 20));
		bottom = new JPanel();
		bottom.setBackground(Color.white);
		
		center = new JPanel();
		center.setLayout(new FlowLayout(0, 40, 20));
		center.setBackground(Color.white);
		
		FlowerInfo flowrInfo1 = new FlowerInfo("img/01adyj.png", "爱到永久", 422);
		FlowerInfo flowrInfo2 = new FlowerInfo("img/01adyj.png", "爱到永久", 422);
		FlowerInfo flowrInfo3 = new FlowerInfo("img/01adyj.png", "爱到永久", 422);
		
		center.add(flowrInfo1);
//		flowrInfo1.setPreferredSize(new Dimension(100,212));
		center.add(flowrInfo2);
		center.add(flowrInfo3);
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
		JFrame frame = new JFrame();
		PanelDemo p = new PanelDemo("花材");
		frame.add(p);
		frame.setVisible(true);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
