package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LabelAndTextField extends JPanel{
	private JLabel label;
	private JTextField textField;
	
	public LabelAndTextField(String name, int isPwd){
		this.setBackground(Color.white);
		this.label = new JLabel(name);
		
		this.add(this.label);
		
		if(isPwd == 0){
			this.textField = new JTextField();
		}else{
			this.textField = new JPasswordField();
		}
		this.textField.setPreferredSize(new Dimension(100, 20));
		this.add(this.textField);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
}
