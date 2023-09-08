package test;

public class Ex02Power {
	public static void main(String[] args) {
		int[] elements = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int element : elements) {
			boolean isPower = isPowerOf2(element);
			System.out.println("==>" + isPower);
			
			System.out.println("============");
			
			System.out.println("7-2: " + isPower(7,2));
			System.out.println("8-2: " + isPower(8,2));
			System.out.println("2-8: " + isPower(2,8));
		}
	}

	private static boolean isPower(int a, int b) {
		double log = a > b ? Math.log(a) / Math.log(b) : Math.log(b) / Math.log(a);
		return Math.ceil(log) == Math.floor(log);
	}

	private static boolean isPowerOf2(int n) {
		// log(n)/log(2) = SN?

		double log = Math.log(n) / Math.log(2);
		System.out.println(n + "==>" + log);
		return Math.ceil(log) == Math.floor(log);
	}
}
