package com.javateam1.flowerstore.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelDemo extends JPanel{
	private MyLabel title;
	private JPanel center;
	private JPanel bottom;
	private MyButton fore, back;
	private String[] data;
	private int page = 0;
	private List<FlowerInfo> flowerlist= new ArrayList<FlowerInfo>();
	private int isdown = 1;
	
	public PanelDemo(String name, String[] data){
		this.data = data;
		title = new MyLabel(name,new Font("宋体", Font.BOLD, 20));
		bottom = new JPanel();
		bottom.setBackground(Color.white);
		
		center = new JPanel();
		center.setLayout(new FlowLayout(0, 40, 20));
		center.setBackground(Color.white);
		
		pageDown();
		
		if((data.length - 3) / 8 > 3){
			fore = new MyButton("上一页");
			back = new MyButton("下一页");
			back.getButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 隐藏掉当前花信息
					pageDown();
				}
			});
			fore.getButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 隐藏掉当前花信息
					pageUp();
				}
			});
		}
		initPanel();
		
	}
	
	public void hideCurFlowerList(){
		for(FlowerInfo f : flowerlist){
			f.setVisible(false);
		}
	}
	
	public void showCurFlowerList(){
		for(FlowerInfo f : flowerlist){
			f.setVisible(true);
		}
	}
	
	public void pageDown(){
		if(isdown == 0){
			isdown = 1;
			page++;
			System.out.println(isdown +" " +page);
		}
		
		int showStart = 3 + page*24;
		int showEnd = 3 + page*24 + 24;
		if (showEnd > data.length){
			showEnd = data.length;
		}
		if(page > (data.length) / 24){
			JOptionPane.showMessageDialog(null, "已经到最后一页了昂！");
			return;
		}
		
		hideCurFlowerList();
		int cur_index = 0;
		for (int i = showStart; i < showEnd; i+=8){
			System.out.println(data[i]);
			String fpath = "img/"+ data[i] +".jpg";
			String fname = data[i + 1];
			double fprice = Double.valueOf(data[i + 2]);
			String[] flowerdata = new String[8];
			System.arraycopy(data, i, flowerdata, 0, 8); 
			if (flowerlist.size() < 3){
				FlowerInfo flowrInfo = new FlowerInfo(fpath, fname, fprice, flowerdata);
				flowerlist.add(flowrInfo);
				center.add(flowrInfo);
			} else{
				FlowerInfo f = flowerlist.get(cur_index);
				f.changeFlowerInfo(fpath, fname, fprice,flowerdata);
				f.setVisible(true);
				cur_index++;
			}
			System.out.println(isdown +" " +page);
		}
		page++;
		initPanel();
	}
	
	public void pageUp(){
		if(isdown == 1){
			isdown = 0;
			page--;
			System.out.println(isdown +" " +page);
		}
		
		if(page <= 0){
			JOptionPane.showMessageDialog(null, "已经到第一页了昂！");
			return;
		}
		page--;
		int showStart = 3 + page*24;
		int showEnd = 3 + page*24 + 24;
		if (showEnd > data.length){
			showEnd = data.length;
		}
		
		hideCurFlowerList();
		int cur_index = 0;
		for (int i = showStart; i < showEnd; i+=8){
			System.out.println(data[i]);
			String fpath = "img/"+ data[i] +".jpg";
			String fname = data[i + 1];
			double fprice = Double.valueOf(data[i + 2]);
			String[] flowerdata = new String[8];
			System.arraycopy(data, showStart, flowerdata, 0, 8); 
			if (flowerlist.size() < 3){
				FlowerInfo flowrInfo = new FlowerInfo(fpath, fname, fprice, flowerdata);
				flowerlist.add(flowrInfo);
				center.add(flowrInfo);
			} else{
				FlowerInfo f = flowerlist.get(cur_index);
				
				f.changeFlowerInfo(fpath, fname, fprice, flowerdata);
				f.setVisible(true);
				cur_index++;
			}
		}
		
		initPanel();
	}
	
	public void initPanel(){
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.add("North", title);
		this.add("Center",center);
		if(fore != null){
			bottom.add(fore);
		}
		if(back != null){
			bottom.add(back);
		}
		this.add("South", bottom);
	}
	
	public static void main(String[] args) {
	}
	
}
