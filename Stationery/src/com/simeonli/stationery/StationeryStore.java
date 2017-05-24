package com.simeonli.stationery;


public class StationeryStore {
	
	public void sale(Pen pen){
		if (pen.isSaled()){
			System.out.println("��֧���Ѿ����ȥ��");
			return;
		}
		System.out.println("��֧" + pen.getName() + "�ۼۣ�" + pen.getPrice());
		pen.setSaled(true);
	}
	
	public void sale(Eraser eraser) throws PersonalException{
		if (eraser.isSaled()){
			throw new PersonalException("�����Ƥ�Ѿ����ȥ��");
		}
		System.out.println("���" + eraser.getName() + "�ۼۣ�" + eraser.getPrice());
		eraser.setSaled(true);
	}
}
