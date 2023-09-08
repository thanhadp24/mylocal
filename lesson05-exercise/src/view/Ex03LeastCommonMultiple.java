package view;

public class Ex03LeastCommonMultiple {
	public static void main(String[] args) {
		// problem 01: get LCM of 2 elements

		// step 1: get GCD of 2 elements
		System.out.println("gcd: " + gcd(12,20));
		// step 2: formula --> LCM = a*b/GCD(a,b)
		System.out.println("lcm: " + lcm(12,20));
		
		System.out.println("=============");
		// problem 02: get LCM of n elements
		int[] elements = {2,3,4,9};
		System.out.println("lcm of n elements: " + lcm(elements));
		
	}

	/**
	 * Least common multiple: bội chung nhỏ nhất Greatest common divisor: ước chung
	 * lớn nhất
	 * 
	 */
	private static int lcm(int[] elements) {
		int length = elements.length;
		if(length == 0) {
			System.out.println("require --> at least 1 elements");
			return Integer.MIN_VALUE;
		}
		if(length == 1) {
			System.out.println("info --> array only has 1 element");
			return elements[0];
		}
		
		int result = lcm(elements[0], elements[1]);
		
		for(int i = 2; i < length; i++) {
			result = lcm(result, elements[i]);
		}
		
		return result;
	}
	
	private static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b -a;
			}
		}
		return a;
	}
}
