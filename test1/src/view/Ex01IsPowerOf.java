package view;

public class Ex01IsPowerOf {
	public static void main(String[] args) {
		System.out.println("8 is power of 2 --->" + isPowerOf(8, 2));
		System.out.println("8 is power of 2 --->" + isPowerOf(2, 8));
		System.out.println("24 is power of 4 --->" + isPowerOf(24, 4));
	}
	
	private static boolean isPowerOf(int num1, int num2) {
		double check = 0;
		if (num1 < num2) {
			check = Math.log(num2) / Math.log(num1);
		} else {
			check = Math.log(num1) / Math.log(num2);
		}
		return Math.ceil(check) == Math.floor(check);
	}
}
