package com.javateam1.flowerstore.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;

public class PanelDemo extends JPanel{
	private MyLabel title;
	private JPanel center;
	private JPanel bottom;
	private MyButton fore, back;
	
	public PanelDemo(String name){
		title = new MyLabel(name,new Font("����", Font.BOLD, 20));
		bottom = new JPanel();
		
		fore = new MyButton("��һҳ");
		back = new MyButton("��һҳ");
		initPanel();
	}
	
	public void initPanel(){
		this.setLayout(new BorderLayout());
		this.add("North", title);
		
		bottom.add(fore);
		bottom.add(back);
		this.add("South", bottom);
	}
	
}
