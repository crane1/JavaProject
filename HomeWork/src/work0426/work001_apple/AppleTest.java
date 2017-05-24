package work0426.work001_apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppleTest {
	public final static boolean isAse = false;
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(new Apple(10, 20));
		appleList.add(new Apple(20, 10));
		appleList.add(new Apple(30, 30));
		appleList.add(new Apple(30, 20));
		
//		//按重量排序
//		appleList.sort(new Comparator<Apple>() {
//
//			@Override
//			public int compare(Apple a1, Apple a2) {
//				if(a1.getWeight() > a2.getWeight() ){
//					return isAse ?1 :-1;  // 是升序则返回1，是倒序则返回-1
//				}else if(a1.getWeight() < a2.getWeight()){
//					return isAse ?-1 :1;
//				}else{
//					if(a1.getVolume() > a2.getVolume() ){
//						return isAse ?1 :-1;  // 是升序则返回1，是倒序则返回-1
//					}else if(a1.getVolume() < a2.getVolume()){
//						return isAse ?-1 :1;
//					}else{
//						return 0;
//					}
//				}
//			}
//		});
//		
		//按大小排序
		appleList.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple a1, Apple a2) {
				if(a1.getVolume() > a2.getVolume() ){
					return isAse ?1 :-1;  // 是升序则返回1，是倒序则返回-1
				}else if(a1.getVolume() < a2.getVolume()){
					return isAse ?-1 :1;
				}else{
					if(a1.getWeight() > a2.getWeight() ){
						return isAse ?1 :-1;  // 是升序则返回1，是倒序则返回-1
					}else if(a1.getWeight() < a2.getWeight()){
						return isAse ?-1 :1;
					}else{
						return 0;
					}
				}
			}
		});
		
		for(Apple a : appleList){
			System.out.println(a);
		}
	}
}
