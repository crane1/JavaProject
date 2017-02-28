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
		jframe.setTitle("̰����");
	}
	
	public void init(){
		// ��ȡjfram���
		Container contentPane = jframe.getContentPane();
		
		// ������岼��Ϊ�߿򲼾�
		contentPane.setLayout(new BorderLayout());
		
		// ��ʼ��̰���߶������
		playArea = new PlayPanel();
		playArea.setBackground(Color.BLUE);
		playArea.setFocusable(true);
        
		// ʵ������ť
		start = new JButton("��ʼ");
		pause = new JButton("��ͣ");
		
		// ��Ӽ����¼�
		start.addActionListener(new StartEvetListener());
		
		// ��������ť��ӵ�һ�������
		JPanel controlPanel = new JPanel();
		controlPanel.add(start);
		controlPanel.add(pause);
		
		// ���������Ͱ�ť�����ӵ�jfram�����
		contentPane.add("Center", playArea);
		contentPane.add("South", controlPanel);
		
		jframe.setSize(400, 300);
		jframe.setVisible(true);
		
		//�������Ķ����߳�  
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
        this.setBackground(Color.blue);//�趨������ɫ  
        snaker.drawSnaker(g);
        food.drawFood(g);
    }  
      
    //�����������߳���ʵ��  
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

