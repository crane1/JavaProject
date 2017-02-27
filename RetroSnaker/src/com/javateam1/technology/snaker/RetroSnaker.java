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
	private JFrame jframe;
	private JButton start, pause;
	private PlayPanel playArea;
	
	public RetroSnaker(){
		jframe = new JFrame();
		jframe.setTitle("̰����");
	}
	
	public void init(){
		Container contentPane = jframe.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		playArea = new PlayPanel();
		playArea.setBackground(Color.BLUE);
		playArea.setFocusable(true);
        
		
		start = new JButton("��ʼ");
		pause = new JButton("��ͣ");
		
		start.addActionListener(new StartEvetListener());
		
		JPanel controlPanel = new JPanel();
		controlPanel.add(start);
		controlPanel.add(pause);
		
		contentPane.add("Center", playArea);
		contentPane.add("South", controlPanel);
		
		jframe.setSize(400, 300);
		jframe.setVisible(true);
		
		
		Thread t = new Thread(playArea);//�������Ķ����߳�  
        t.start();
	}
	public static void main(String[] args) {
		RetroSnaker snaker = new RetroSnaker();
		snaker.init();
	}
}

class PlayPanel extends JPanel implements Runnable{
	Snaker snaker;
	
    public PlayPanel(){
    	this.setSize(400, 300);
    	snaker = new Snaker();
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
            Thread.sleep(100);
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }
        repaint(); 
//        System.out.println("--------------movesnaker");
        snaker.move();
    }
}  

