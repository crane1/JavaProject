package com.javateam1.technology.snaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.lang.Thread.State;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RetroSnaker {
	public final static int PANEL_WIDTH = 400;
	public final static int PANEL_HEIGHT = 300;
	
	private JFrame jframe;
	private JButton start, pause;
	private JLabel score, deep;
	private PlayPanel playArea;
	private Thread t;
	
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
		playArea.setPreferredSize(new Dimension(PlayPanel.PANEL_WIDTH, PlayPanel.PANEL_HEIGHT));
//		playArea.setSize(PlayPanel.PANEL_WIDTH, PlayPanel.PANEL_HEIGHT);
		playArea.setBackground(Color.BLUE);
		playArea.setFocusable(true);
		
		// 添加一个Component来撑大JFrame
		
        
		// 实例化按钮
		start = new JButton("开始");
		pause = new JButton("暂停");
		score = new JLabel("分数：0");
		deep = new JLabel("速度：0");
		playArea.score = score;
		playArea.deep = deep;
		
		// 添加监听事件
		start.addActionListener(new ButtonEvetListener());
		pause.addActionListener(new ButtonEvetListener());
		
		// 将两个按钮添加到一个面板上
		JPanel controlPanel = new JPanel();
//		controlPanel.setSize(400, 100);
		controlPanel.add(start);
		controlPanel.add(pause);
		controlPanel.add(score);
		controlPanel.add(deep);
		
		// 将动画面板和按钮面板添加到jfram面板上
		contentPane.add("Center", playArea);
		contentPane.add("South", controlPanel);
		
		contentPane.add(playArea);
//		contentPane.add(controlPanel);
		
//		jframe.setSize(RetroSnaker.PANEL_WIDTH + 20, RetroSnaker.PANEL_HEIGHT);
		jframe.pack();  //让窗体自适应组建大小
		jframe.setVisible(true);
		jframe.setLocationRelativeTo(null);
		
		//启动面板的动画线程  
		
	}
	
	class ButtonEvetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b == start){
				if (t == null){
					t = new Thread(playArea);
					t.start();
					System.out.println("游戏开始了。。。");
				}
					
			} else if (b == pause){
				if (playArea.getSuspend() == 0){
					System.out.println("游戏暂停了。。。");
					playArea.pause();
				} else{
					System.out.println("游戏开始了。。。");
					playArea.resume();
				}
			}
			playArea.requestFocus();
		}

	}
}

class PlayPanel extends JPanel implements Runnable{
	public final static int PANEL_WIDTH = 400;
	public final static int PANEL_HEIGHT = 200;
	Snaker snaker;
	Food food;
	JLabel score, deep;
	private int suspend = 0; //0表示不暂停 
	
	
    public PlayPanel(){
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
        this.setSize(PlayPanel.PANEL_WIDTH, PlayPanel.PANEL_HEIGHT);
        snaker.drawSnaker(g);
        food.drawFood(g);
    }
      
    //动画过程在线程内实现  
    @Override  
    public void run() {
    	initPanel();
    	int deep = 0;
    	synchronized (this) {
    		while(true){
        		if(suspend == 0){
        			deep = snaker.getSnakerDeep();
//            		System.out.println("deep=" + deep + " score = " + snaker.getScore());
            		snakerMove(deep);
        		}else{
        			try {
    					wait();
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
        		}
        		
        	}
		}
    	
    }
    
    public void snakerMove(int deep){
    	try {
            Thread.sleep(deep);
        } catch (InterruptedException e) { 
            e.printStackTrace();  
        }
        repaint(); 
//        System.out.println("--------------movesnaker");
        snaker.move();
        boolean iseat = snaker.eatFood(food);
        if(iseat){
        	setScore();
        	setDeep();
        }
    }
    
    public void setScore(){
    	int tscore = snaker.getScore();
    	score.setText("分数：" + Integer.toString(tscore));
    }
    
    public void setDeep(){
    	int tdeep = snaker.getDeep();
    	deep.setText("速度：" + Integer.toString(tdeep));
    }

	public int getSuspend() {
		return suspend;
	}

	public void pause() {
		this.suspend = 1;
	}
	
	public synchronized void resume(){
		this.suspend = 0;
		notifyAll();
	}
    
    
    
}  

