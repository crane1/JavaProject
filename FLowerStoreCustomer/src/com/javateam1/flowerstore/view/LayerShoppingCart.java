package com.javateam1.flowerstore.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.javateam1.flowerstore.control.ArrayToString;
import com.javateam1.flowerstore.control.DataType;
import com.javateam1.flowerstore.control.TCPClient;

/**
 * 
 * @author 李泽明
 *  购物车页面类
 *
 */
public class LayerShoppingCart extends LayerDemo{
	private List<FlowerinfoInCart> list = new ArrayList<FlowerinfoInCart>();
	private JPanel panel = new JPanel();
	private JScrollPane scroll = new JScrollPane(panel);
	private JPanel bottom = new JPanel();
	private MyLabel pay_num = new MyLabel("总付款：0元", null);
	private MyButton btnPay = new MyButton("结账");
	private double pay_total_money = 0;
	private Set<String> select_num = new HashSet<String>();
	
	public LayerShoppingCart(TCPClient client){
		super(client);
		scroll.setPreferredSize(new Dimension(280, 400));
		getCon().add(scroll);
		
		bottom.add(pay_num);
		bottom.add(btnPay);
		getCon().add("South",bottom);
		
		btnPay.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int size = select_num.size() + 1;
				
				String[] dataArray = new String[size];
				dataArray[0] = DataType.PAY;
				Iterator<String> it = select_num.iterator();
				for(int i = 0; i < select_num.size(); i++){
					if(it.hasNext()){
						dataArray[i+1] = it.next();
					}
				}
				if (size == 1){
					JOptionPane.showMessageDialog(null, "没有选定要支付的物品");
				}else {
					String data = ArrayToString.arrayToString(dataArray);
					LayerManager.pushData(data);
				}
			}
		});
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w){
				LayerManager.hideLayer(DataType.VIEW_SHOP);
			}
		});
	}
	
	public void addFlowerInfoList(String[] data){
		if(data.length == 1){
			panel.setVisible(false);
		}
		panel.removeAll();
		select_num.clear();
		pay_total_money = 0;
		pay_num.setText("总付款：" + pay_total_money + "元");
		int size = (data.length - 1) / 5;
		panel.setLayout(new GridLayout(size, 1, 0, 10));
		for(int i = 1; i < data.length; i=i+5){
			FlowerinfoInCart f = new FlowerinfoInCart(data[i], data[i+1], data[i+2], data[i+3], data[i+4]);
			list.add(f);
			panel.add(f);
		}
		initPanel();
	}
	
	class FlowerinfoInCart extends JPanel{
		private JPanel left = new JPanel();
		private JCheckBox select = new JCheckBox();
		private JLabel pic = new JLabel(); 
		private JPanel right = new JPanel();
		private MyLabel name = new MyLabel("",null);
		private MyLabel price = new MyLabel("价格:",null);
		private MyLabel num = new MyLabel("数量:",null);
		private MyLabel total_price = new MyLabel("总价:",null);
		private double total_money = 0;
		private JPanel mainPanel = new JPanel();
		
		public FlowerinfoInCart(){}
		public FlowerinfoInCart(final String id, String name, String price, String num, String total_price){
			this.total_money = Double.parseDouble(total_price);
			this.pic.setIcon(new ImageIcon("img/" + id + ".jpg"));
			this.name.getLabel().setText(name);
			this.price.getLabel().setText("单价：" + price);
			this.num.getLabel().setText("数量：" + num);
			this.total_price.getLabel().setText("总价：" + total_price);
			
			select.setBackground(Color.white);
			left.add(select);
			left.add(this.pic);
			left.setBackground(Color.white);
			
			right.setLayout(new GridLayout(4,1));
			right.add(this.name);
			right.add(this.price);
			right.add(this.num);
			right.add(this.total_price);
			
			this.setBackground(Color.white);
			this.setLayout(new GridLayout(1,2));
			
			mainPanel.add(left);
			mainPanel.add(right);
			this.add(mainPanel);
			mainPanel.setBackground(Color.white);
			
			select.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == select){
						if(select.isSelected()){
							pay_total_money += total_money;
							select_num.add(id);
						}else{
							pay_total_money -= total_money;
							select_num.remove(id);
						}
					}
//					for(String s : select_num){
//						System.out.println(s);
//					}
					pay_num.setText("总付款：" + pay_total_money + "元");
				}
			});
		}
		
	}
	public static void main(String[] args) {
	}
}
