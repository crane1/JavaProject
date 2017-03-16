package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlowerInfo extends JPanel {
	private JLabel pic = new JLabel(); 
	private MyLabel name = new MyLabel("",null);
	private JLabel pname = new JLabel("心动价格:");
	private JLabel price = new JLabel();
	
	public FlowerInfo(String picPath, String name, double price){
		this.setBackground(Color.white);
		this.setLayout(null);
		this.pic.setIcon(new ImageIcon(picPath));
		this.pic.setBounds(0, 0, 100, 150);
		
		this.name.getLabel().setText(name);
		this.name.setBounds(0, 160, 100, 20);
		
		this.price.setText(String.valueOf(price));
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.add(this.pname);
		panel.add(this.price);
		panel.setBounds(0, 190, 100, 20);
		
		this.add(this.pic);
		this.add(this.name);
		this.add(panel);
		this.setPreferredSize(new Dimension(100,212));
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		FlowerInfo p = new FlowerInfo("img/01adyj.png", "爱到永久", 422);
		frame.add(p);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
