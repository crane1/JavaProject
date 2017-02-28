package com.javateam1.technology.snaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RetroSnaker {
	public final static int PANEL_WIDTH = 400;
	public final static int PANEL_HEIGHT = 300;
	
	private JFrame jframe;
	private JButton start, pause;
	private PlayPanel playArea;
	
	public RetroSnaker(){
		jframe = new JFrame();
		jframe.setTitle("贪吃蛇");
	}
	
	public void init(){
		// 获取jfram面板
		Container contentPane = jframe.getContentPane();
		
		// 设置面板布局为边框布局
		contentPane.setLayout(new BorderLayout());
		
		// 初始化贪吃蛇动画面板
		playArea = new PlayPanel();
		playArea.setBackground(Color.BLUE);
		playArea.setFocusable(true);
        
		// 实例化按钮
		start = new JButton("开始");
		pause = new JButton("暂停");
		
		// 添加监听事件
		start.addActionListener(new StartEvetListener());
		
		// 将两个按钮添加到一个面板上
		JPanel controlPanel = new JPanel();
		controlPanel.add(start);
		controlPanel.add(pause);
		
		// 将动画面板和按钮面板添加到jfram面板上
		contentPane.add("Center", playArea);
		contentPane.add("South", controlPanel);
		
		jframe.setSize(400, 300);
		jframe.setVisible(true);
		
		//启动面板的动画线程  
		Thread t = new Thread(playArea);
        t.start();
	}
}

class PlayPanel extends JPanel implements Runnable{
	Snaker snaker;
	Food food;
	
    public PlayPanel(){
    	this.setSize(400, 300);
    	snaker = new Snaker();
    	food = new Food();
//    	initPanel();
    }
    
    public void initPanel(){
    	System.out.println("initpanle");
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_UP:
//					System.out.println("up");
					snaker.turnHead(Direction.UP);
					break;
				case KeyEvent.VK_RIGHT:
//					System.out.println("right");
					snaker.turnHead(Direction.RIGHT);
					break;
				case KeyEvent.VK_DOWN:
//					System.out.println("down");
					snaker.turnHead(Direction.DOWN);
					break;
				case KeyEvent.VK_LEFT:
//					System.out.println("left");
					snaker.turnHead(Direction.LEFT);
					break;
				}
			}
		});
    }
    
    @Override  
    public void paint(Graphics g) {
//    	System.out.println("----------");
        super.paint(g);
        this.setBackground(Color.blue);//设定背景颜色  
        snaker.drawSnaker(g);
        food.drawFood(g);
    }  
      
    //动画过程在线程内实现  
    @Override  
    public void run() {
    	initPanel();
    	while(true){
    		snakerMove();
    	}
    }
    
    public void snakerMove(){
    	try {  
            Thread.sleep(500);
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }
        repaint(); 
//        System.out.println("--------------movesnaker");
        snaker.move();
        snaker.eatFood(food);
    }
}  

