package view;

public class Ex03GetLeastCommonMultiple {
	public static void main(String[] args) {
		System.out.println(gcd(8, 12));
		System.out.println(lcm(8, 12));
		int[] a = { 2, 3, 4, 5 };
		System.out.println(lcm(a));
	}

	private static int lcm(int[] a) {
		if (a.length == 0) {
			throw new NullPointerException("array cannot be empty, at least 1 elements");
		} else if (a.length == 1) {
			return a[0];
		}
		int tmp = lcm(a[0], a[1]);
		for (int i = 2; i < a.length; i++) {
			tmp = lcm(tmp, a[i]);
		}

		return tmp;
	}

	private static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		if (a == b)
			return a;
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}
}
