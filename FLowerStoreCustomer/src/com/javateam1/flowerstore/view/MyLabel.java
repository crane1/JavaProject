package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyLabel extends JPanel{
	private JLabel label;
	
	public MyLabel(String name, Font f){
		this.setBackground(Color.white);
		label = new JLabel(name);
		label.setAlignmentX(0);
		label.setFont(f);
		this.add(label);
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	public void setTextColor(Color c){
		label.setForeground(c);
	}
	
	public void setText(String s){
		label.setText(s);
	}
	
}
