package com.javateam1.flowerstore.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyButton extends JPanel{
	private JButton button;
	
	public MyButton(String name){
		this.setBackground(Color.white);
		button = new JButton(name);
		this.add(button);
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}
	
	
}
