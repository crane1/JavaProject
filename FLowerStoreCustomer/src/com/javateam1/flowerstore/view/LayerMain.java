package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.javateam1.flowerstore.control.ArrayToString;
import com.javateam1.flowerstore.control.DataType;
import com.javateam1.flowerstore.control.TCPClient;

@SuppressWarnings("serial")
public class LayerMain extends LayerDemo {
	private final String[] maters = {"红玫瑰","康乃馨","郁金香"}; 
	private final String[] prices = {"0-100","100-200","200-500","500-1000"};
	private final String[] types = {"创意礼盒","精美花束"}; 
	private final String[] nums = {"19","99"}; 
	private MainPanelManager panelManager = new MainPanelManager(this);
	private MyLabel lbtitle = new MyLabel("网上呆萌花店",new Font("宋体", Font.BOLD, 22));
	private MyButton btnAccount = new MyButton("登录");
	private MyButton btnShoppingCart = new MyButton("我的购物车");
	private MyButton btnOrders = new MyButton("我的订单");
	private MyButton btnFirst = new MyButton("首页");
	private MyComboBox btnMater = new MyComboBox(); 
	private MyComboBox btnPrice = new MyComboBox();
	private MyComboBox btnType = new MyComboBox();
	private MyComboBox btnNum = new MyComboBox();
	private Container con = this.getCon();
	
	private void initButton(){
		for(String s : maters){
			btnMater.addItem(s);
		}
		for(String s : prices){
			btnPrice.addItem(s);
		}
		for(String s : types){
			btnType.addItem(s);
		}
		for(String s : nums){
			btnNum.addItem(s);
		}
	}
	
	
	public LayerMain(TCPClient client){
		super(client);
		this.setTitle("网上呆萌花店");
		this.setPreferredSize(new Dimension(485,550));
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(2,1));
		JPanel top1 = new JPanel();
		top1.setBackground(Color.white);
		top1.add(lbtitle);
		top1.add(btnAccount);
		top1.add(btnShoppingCart);
		top1.add(btnOrders);
		
		top.add(top1);
		JPanel top2 = new JPanel();
		top2.setLayout(new GridLayout(1,5));
		initButton();
		top2.add(btnFirst);
		top2.add(btnMater);
		top2.add(btnPrice);
		top2.add(btnType);
		top2.add(btnNum);
		top.add(top2);
		con.add("North", top);
		String ftype = btnFirst.getButton().getText();
		String[] dataArray = {DataType.MAIN, DataType.FIRST, ftype}; 
		String data = ArrayToString.arrayToString(dataArray);
		LayerManager.pushData(data);
		initPanel();
		
		btnFirst.getButton().addActionListener(new myButtonListener());
		btnMater.getComboBox().addActionListener(new myButtonListener());
		btnPrice.getComboBox().addActionListener(new myButtonListener());
		btnType.getComboBox().addActionListener(new myButtonListener());
		btnNum.getComboBox().addActionListener(new myButtonListener());
		btnShoppingCart.getButton().addActionListener(new myButtonListener());
		btnAccount.getButton().addActionListener(new myButtonListener());
		btnOrders.getButton().addActionListener(new myButtonListener());
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w){
				LayerManager.hideLayer(DataType.MAIN);
				System.exit(0);
			}
		});
	}
	
	class myButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String type = DataType.MAIN;
			String ttype = null;
			String ftype = null;
			if(e.getSource() == btnFirst.getButton()){
				ttype = DataType.FIRST;
				ftype = btnFirst.getButton().getText();
			}else if(e.getSource() == btnMater.getComboBox()){
				ttype = DataType.MATER;
				ftype = (String)btnMater.getComboBox().getSelectedItem();
			}else if(e.getSource() == btnPrice.getComboBox()){
				ttype = DataType.PRICE;
				ftype = (String)btnPrice.getComboBox().getSelectedItem();
			}else if(e.getSource() == btnType.getComboBox()){
				ttype = DataType.TYPE;
				ftype = (String)btnType.getComboBox().getSelectedItem();
			}else if(e.getSource() == btnNum.getComboBox()){
				ttype = DataType.NUMBER;
				ftype = (String)btnNum.getComboBox().getSelectedItem();
			}else if(e.getSource() == btnShoppingCart.getButton()){
				type = DataType.VIEW_SHOP;
			}else if(e.getSource() == btnAccount.getButton()){
				type = DataType.VIEW_ACCOUNT;
			}else if(e.getSource() == btnOrders.getButton()){
				type = DataType.VIEW_ORDER;
			}
			
			String[] dataArray = null; 
			if (!type.equals(DataType.MAIN)){
				dataArray =new String[]{type};
			}else if (ftype != null){
				dataArray =new String[]{DataType.MAIN, ttype, ftype};
			} else{
				dataArray =new String[]{DataType.MAIN, ttype};
			}
			
			String data = ArrayToString.arrayToString(dataArray);
			LayerManager.pushData(data);
		}
		
	}
	
	public MainPanelManager getPanelManager() {
		return panelManager;
	}


	public void setPanelManager(MainPanelManager panelManager) {
		this.panelManager = panelManager;
	}

	

	public MyButton getLbAccount() {
		return btnAccount;
	}


	public void setLbAccount(MyButton lbAccount) {
		this.btnAccount = lbAccount;
	}


	public static void main(String[] args) {
		StringBuffer sb = null;
		JFrame j = new JFrame();
		j.setVisible(true);
		j.setSize(200, 300);
        sb = new StringBuffer("<html>xxxx<br/>yyy</html>");
        JLabel  jLabel1 = new JLabel();
        jLabel1.setText(sb.toString());
        j.add(jLabel1);
	}

}
