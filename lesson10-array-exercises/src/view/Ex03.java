package view;

import java.util.Arrays;
import java.util.Comparator;

/**
 Cho mảng n phần tử chứa số âm, dương, chuỗi special, chuỗi kí tự normal
 hãy sort 
 Biết: special => số âm => số dương => tăng dần các chuỗi còn lại trong mảng 
 Ngược lại: giảm dần các chuỗi còn lại => dương => âm => special
 vd: String text = {"-2", "-6", "10", "null","special", "5", "a", "d", "xx"}; 
 --> tăng:special, -2, -6, 5, 10, a,d,xx,null
 */

public class Ex03 {
	public static void main(String[] args) {
		String[] elements = {"-2", "k", "-6", "10", "v", null,"special", "5", "a", "d", "xx"}; 
		
		Arrays.sort(elements, Comparator.nullsLast(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.compareTo("special") == 0) {
					return -1;
				}
				
				if (o2.compareTo("special")== 0) {
					return 5;
				}
				
				if (o1.matches("\\d+") && o2.matches("\\d+")) {
					return Integer.parseInt(o1) - Integer.parseInt(o2);
				}
				
				return o1.compareTo(o2);
			}
		}).reversed());
		
		System.out.println(Arrays.toString(elements));
	}
	
	
}
