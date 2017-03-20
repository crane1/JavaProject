package com.javateam1.flowerstore.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDemo extends JPanel{
	private MyLabel title;
	private JPanel center;
	private JPanel bottom;
	private MyButton fore, back;
	private String[] data;
	private int page = 0;
	private List<FlowerInfo> flowerlist= new ArrayList<FlowerInfo>();
	
	public PanelDemo(String name, String[] data){
		this.data = data;
		title = new MyLabel(name,new Font("宋体", Font.BOLD, 20));
		bottom = new JPanel();
		bottom.setBackground(Color.white);
		
		center = new JPanel();
		center.setLayout(new FlowLayout(0, 40, 20));
		center.setBackground(Color.white);
		
//		list.add(f.getId());
//		list.add(f.getName());
//		list.add(String.valueOf(f.getPrice()));
//		list.add(f.getMaterials());
//		list.add(f.getPackages());
//		list.add(String.valueOf(f.getNum()));
//		list.add(f.getType());
//		list.add(f.getFlowerWord());
		addFlower();
		
		if((data.length - 3) / 8 > 3){
			fore = new MyButton("上一页");
			back = new MyButton("下一页");
			back.getButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 隐藏掉当前花信息
					for(FlowerInfo f : flowerlist){
						f.setVisible(false);
					}
					addFlower();
				}
			});
		}
		initPanel();
		
	}
	
	public void addFlower(){
		System.out.println(page);
		int showStart = 3 + page*24;
		int showEnd = 3 + page*24 + 24;
		if (showEnd > data.length){
			showEnd = data.length;
		}
		int cur_index = 0;
		for (int i = showStart; i < showEnd; i+=8){
			System.out.println(data[i]);
			String fpath = "img/"+ data[i] +".jpg";
			String fname = data[i + 1];
			double fprice = Double.valueOf(data[i + 2]);
			if (flowerlist.size() < 3){
				FlowerInfo flowrInfo = new FlowerInfo(fpath, fname, fprice);
				flowerlist.add(flowrInfo);
				center.add(flowrInfo);
			} else{
				FlowerInfo f = flowerlist.get(cur_index);
				f.changeFlowerInfo(fpath, fname, fprice);
				f.setVisible(true);
				cur_index++;
			}
		}
		page++;
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
