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
		jframe.setTitle("̰����");
	}
	
	public void init(){
		// ��ȡjfram���
		Container contentPane = jframe.getContentPane();
		
		// ������岼��Ϊ�߿򲼾�
		contentPane.setLayout(new BorderLayout());
		
		// ��ʼ��̰���߶������
		playArea = new PlayPanel();
		playArea.setPreferredSize(new Dimension(PlayPanel.PANEL_WIDTH, PlayPanel.PANEL_HEIGHT));
//		playArea.setSize(PlayPanel.PANEL_WIDTH, PlayPanel.PANEL_HEIGHT);
		playArea.setBackground(Color.BLUE);
		playArea.setFocusable(true);
		
		// ���һ��Component���Ŵ�JFrame
		
        
		// ʵ������ť
		start = new JButton("��ʼ");
		pause = new JButton("��ͣ");
		score = new JLabel("������0");
		deep = new JLabel("�ٶȣ�0");
		playArea.score = score;
		playArea.deep = deep;
		
		// ��Ӽ����¼�
		start.addActionListener(new ButtonEvetListener());
		pause.addActionListener(new ButtonEvetListener());
		
		// ��������ť��ӵ�һ�������
		JPanel controlPanel = new JPanel();
//		controlPanel.setSize(400, 100);
		controlPanel.add(start);
		controlPanel.add(pause);
		controlPanel.add(score);
		controlPanel.add(deep);
		
		// ���������Ͱ�ť�����ӵ�jfram�����
		contentPane.add("Center", playArea);
		contentPane.add("South", controlPanel);
		
		contentPane.add(playArea);
//		contentPane.add(controlPanel);
		
//		jframe.setSize(RetroSnaker.PANEL_WIDTH + 20, RetroSnaker.PANEL_HEIGHT);
		jframe.pack();  //�ô�������Ӧ�齨��С
		jframe.setVisible(true);
		jframe.setLocationRelativeTo(null);
		
		//�������Ķ����߳�  
		
	}
	
	class ButtonEvetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b == start){
				if (t == null){
					t = new Thread(playArea);
					t.start();
					System.out.println("��Ϸ��ʼ�ˡ�����");
				}
					
			} else if (b == pause){
				if (playArea.getSuspend() == 0){
					System.out.println("��Ϸ��ͣ�ˡ�����");
					playArea.pause();
				} else{
					System.out.println("��Ϸ��ʼ�ˡ�����");
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
	private int suspend = 0; //0��ʾ����ͣ 
	
	
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
        this.setBackground(Color.blue);//�趨������ɫ  
        this.setSize(PlayPanel.PANEL_WIDTH, PlayPanel.PANEL_HEIGHT);
        snaker.drawSnaker(g);
        food.drawFood(g);
    }
      
    //�����������߳���ʵ��  
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
    	score.setText("������" + Integer.toString(tscore));
    }
    
    public void setDeep(){
    	int tdeep = snaker.getDeep();
    	deep.setText("�ٶȣ�" + Integer.toString(tdeep));
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

