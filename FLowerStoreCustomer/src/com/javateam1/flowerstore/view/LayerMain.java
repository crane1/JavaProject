package com.javateam1.flowerstore.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.javateam1.flowerstore.control.ArrayToString;
import com.javateam1.flowerstore.control.DataType;


public class LayerMain extends LayerDemo {
	private MainPanelManager panelManager = new MainPanelManager(this);
	private MyLabel lbtitle = new MyLabel("网上呆萌花店",new Font("宋体", Font.BOLD, 30));
	private MyButton btnFirst = new MyButton("首页");
	private MyButton btnMater = new MyButton("花材"); 
	private MyButton btnPrice = new MyButton("价格");
	private MyButton btnType = new MyButton("类型");
	private MyButton btnNum = new MyButton("支数");
	private Container con = this.getCon();
	
	public LayerMain(){
		super();
		this.setTitle("网上呆萌花店");
		this.setPreferredSize(new Dimension(485,450));
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(2,1));
		top.add(lbtitle);
		JPanel top2 = new JPanel();
		top2.setLayout(new GridLayout(1,5));
		top2.add(btnFirst);
		top2.add(btnMater);
		top2.add(btnPrice);
		top2.add(btnType);
		top2.add(btnNum);
		top.add(top2);
		con.add("North", top);
		panelManager.addPanel("精品推荐");
		initPanel();
		
		btnFirst.getButton().addActionListener(new myButtonListener());
		btnMater.getButton().addActionListener(new myButtonListener());
		btnPrice.getButton().addActionListener(new myButtonListener());
		btnType.getButton().addActionListener(new myButtonListener());
		btnNum.getButton().addActionListener(new myButtonListener());
	}
	
	class myButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String type = "first";
			if(e.getSource() == btnFirst.getButton()){
				type = "first";
				panelManager.addPanel("精品推荐");
			}else if(e.getSource() == btnMater.getButton()){
				type = "mater";
				panelManager.addPanel("花材");
			}else if(e.getSource() == btnPrice.getButton()){
				type = "price";
				panelManager.addPanel("价格");
			}else if(e.getSource() == btnType.getButton()){
				type = "type";
				panelManager.addPanel("类型");
			}else if(e.getSource() == btnNum.getButton()){
				type = "number";
				panelManager.addPanel("支数");
			}
			System.out.println("加载内容");
			initPanel();
			
			String[] dataArray = {DataType.MAIN, type}; 
			String data = ArrayToString.arrayToString(dataArray);
			pushData(data);
		}
		
	}
	
	private void pushData(String data) {
		System.out.println(this.getClient());
		this.getClient().pushData(data);
	}
	
	public static void main(String[] args) {
		new LayerMain();
	}

}
