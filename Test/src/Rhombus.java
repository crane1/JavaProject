
public class Rhombus {
	
	public static void showRhombus(int rhombusRowNum, char star){
		int blankNum = rhombusRowNum - 1;
		int starNum = 1;
		for (int i = 0; i < rhombusRowNum * 2 - 1; i++) {
			printBlank(blankNum);
			printStart(starNum, star);
			printChgLine();
			if(i < rhombusRowNum - 1){
				blankNum--;
				starNum += 2;
			}else{
				blankNum++;
				starNum -= 2;
			}
			
		}
	}
	
	public static void printBlank(int ptrBlankNum){
		for(int i = 0; i < ptrBlankNum; i++){
			System.out.print(" ");
		}
	}
	
	public static void printStart(int ptrStartNum, char star){
		for(int i = 0; i < ptrStartNum; i++){
			System.out.print(star);
		}
	}
	
	public static void printChgLine(){
		System.out.println();
	}
	
	public static void main(String[] args) {
		showRhombus(4, 'H');
	}
}
