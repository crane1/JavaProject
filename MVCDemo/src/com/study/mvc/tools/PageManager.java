package com.study.mvc.tools;

public class PageManager {
	private static int maxPageRows;  //ÿҳ�������
	private static int curPageNo; //��ǰҳ
	private static int maxRowNumber; //�������
	public static boolean initFlag = false;
	
	public static void PageManagerInit(int _maxPageRows, int _curPageNo){
		maxPageRows = _maxPageRows;
		curPageNo = _curPageNo;
	}
	
	public static void setCurPageNo(int num)
	{
		curPageNo = num;
	}
	
	public static int getCurPageNo(){
		return curPageNo;
	}
	
	
	public static int getMaxPageRows(){
		return maxPageRows;
	}
	public static void setMaxRowNumber(int num){
		maxRowNumber = num;
	}
	public static int getMaxPageNo(){
		return maxRowNumber / maxPageRows + 1;
	}
	
	
	public static int getNextPageNo(){
		if(curPageNo >= maxRowNumber){
			return maxRowNumber;
		}else{
			return curPageNo + 1;
		}
	}
	
	public static int getPrePageNo(){
		if(curPageNo <= 1){
			return 1;
		}else{
			return curPageNo - 1;
		}
	}
	
	
	
	public static void setAppointNo(int num){
		curPageNo = num;
	}

}
