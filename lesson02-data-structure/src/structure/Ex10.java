package structure;

import bean.CustomInteger;

// swap 2 số nguyên (int, Integer)
public class Ex10 {
	public static void main(String[] args) {
		CustomInteger a = new CustomInteger(12);
		CustomInteger b = new CustomInteger(36);
		
		// case 1 --> code in main method
		//a = b + 0*(b=a);
	
		swap(a, b);
		System.out.println(a);
		System.out.println(b);
	}
	
	// case 2 --> create a method for reusable
	// PASS BY VALUE 
	private static void swap(CustomInteger f, CustomInteger s) {
		int tmp = f.value;
		f.value = s.value;
		s.value = tmp;
		
		//f.value = s.value + 0*(s.value = f.value);
	}
}
