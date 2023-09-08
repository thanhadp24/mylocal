package polymorphism.method;

public class PolyMethodOverload {
	public static void main(String[] args) {
		int x = 5;
		int y = 10;
		int z = 15;
		
		System.out.println("sum2: " + sum(x, y));
		System.out.println("sum3: " + sum(x, y, x));
		System.out.println("sumf: " + sum(5.2f, 1.2f));
	}
	
	private static float sum(float a, float b) {
		return a + b;
	}
	
	private static int sum(int a, int b) {
		return a + b;
	}
	
	private static int sum(int a, int b, int c) {
		return a + b + c;
	}
}
