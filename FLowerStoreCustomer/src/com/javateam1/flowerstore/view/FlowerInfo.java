package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlowerInfo extends JPanel {
	private JLabel pic = new JLabel(); 
	private MyLabel name = new MyLabel("",null);
	private JLabel pname = new JLabel("心动价格:");
	private JLabel price = new JLabel();
	private MyButton addShoppingCart = new MyButton("加入购物车");
	private MyButton viewDetails = new MyButton("查看详情");
	
	private String[] data;
	
	public FlowerInfo(String picPath, String name, double price, final String[] data){
		this.data = data;
		
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
		this.addShoppingCart.setBounds(0, 220, 100, 40);
		this.viewDetails.setBounds(0, 270, 100, 40);
		
		this.add(this.pic);
		this.add(this.name);
		this.add(panel);
		this.add(addShoppingCart);
		this.add(viewDetails);
		this.setPreferredSize(new Dimension(100,320));
		
		addShoppingCart.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		viewDetails.getButton().addActionListener(new myActionListener());
	}
	
	class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(data[0]);
			LayerFlowerDetail.showFlowerInfo(data);
			
		}
		
	}
	
	public void changeFlowerInfo(String picPath, String name, double price, final String[] data){
		this.data = data;
		this.pic.setIcon(new ImageIcon(picPath));
		this.name.getLabel().setText(name);
		this.name.getLabel().setText(name);
		this.price.setText(String.valueOf(price));
		addShoppingCart.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		viewDetails.getButton().addActionListener(new myActionListener());
	}
	
	
	
	public static void main(String[] args) {
	}
	
}
