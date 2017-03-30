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

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.javateam1.flowerstore.control.ArrayToString;
import com.javateam1.flowerstore.control.DataType;
import com.javateam1.flowerstore.control.TCPClient;

@SuppressWarnings("serial")
public class LayerOrders extends LayerDemo{
	private List<OrderinfoInCart> list = new ArrayList<OrderinfoInCart>();
	private JPanel panel = new JPanel();
	private JScrollPane scroll = new JScrollPane(panel);
	private MyButton btnDel = new MyButton("删除");
	private Set<String> select_num = new HashSet<String>();
	
	public LayerOrders(TCPClient client){
		super(client);
		scroll.setPreferredSize(new Dimension(280, 400));
		getCon().add(scroll);
		
		JPanel bottom = new JPanel();
		bottom.add(btnDel);
		getCon().add("South",bottom);
		
		btnDel.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int size = select_num.size() + 1;
				
				String[] dataArray = new String[size];
				dataArray[0] = DataType.DELETE_ORDER;
				Iterator<String> it = select_num.iterator();
				for(int i = 0; i < select_num.size(); i++){
					if(it.hasNext()){
						dataArray[i+1] = it.next();
					}
				}
				if (size == 1){
					JOptionPane.showMessageDialog(null, "没有选定要删除的物品");
				}else {
					String data = ArrayToString.arrayToString(dataArray);
					LayerManager.pushData(data);
				}
			}
		});
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w){
				LayerManager.hideLayer(DataType.VIEW_ORDER);
			}
		});
	}
	
	public void addOrderInfoList(String[] data){
		panel.removeAll();
		int size = (data.length - 1) / 5;
		panel.setLayout(new GridLayout(size, 1, 0, 0));
		for(int i = 1; i < data.length; i=i+5){
			OrderinfoInCart f = new OrderinfoInCart(data[i], data[i+1], data[i+2], data[i+3], data[i+4]);
			list.add(f);
			panel.add(f);
		}
		initPanel();
	}
	
	class OrderinfoInCart extends JPanel{
		private JPanel left = new JPanel();
		private JCheckBox select = new JCheckBox();
		private JPanel right = new JPanel();
		private MyLabel id = new MyLabel("",null);
		private MyLabel info = new MyLabel("",null); // 物品信息
		private MyLabel total_price = new MyLabel("总价:",null);
		private MyLabel time = new MyLabel("",null);
		private MyLabel ispay = new MyLabel("",null);
		private JPanel mainPanel = new JPanel();
		
		public OrderinfoInCart(){}
		public OrderinfoInCart(final String id, String info, String total_price, String time, String ispay){
			this.id.getLabel().setText("订单编号：" + id);
			
//			sb = new StringBuffer("<html>" + info + "</html>");
//			info = "<html>" + info + "</html>";
//			info = info.replace(" ", "<br/>");
			this.info.getLabel().setText(info);
			this.total_price.getLabel().setText("总价：" + total_price);
			this.time.getLabel().setText("时间：" + time);
			if(ispay.equals("false")){
				this.ispay.getLabel().setText("支付状态：未支付");
			}else{
				this.ispay.getLabel().setText("支付状态：已支付");
			}
			
			
			select.setBackground(Color.white);
			left.add(select);
			left.setBackground(Color.white);
			
			right.setLayout(new GridLayout(5,1));
			right.add(this.id);
			right.add(this.info);
			right.add(this.total_price);
			right.add(this.time);
			right.add(this.ispay);
			
			mainPanel.setBackground(Color.white);
			mainPanel.setLayout(new GridLayout(1,2));
			mainPanel.add(left);
			mainPanel.add(right);
			this.add(mainPanel);
			
			select.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == select){
						if(select.isSelected()){
							select_num.add(id);
						}else{
							select_num.remove(id);
						}
					}
				}
			});
		}
		
	}
	public static void main(String[] args) {
	}
}
