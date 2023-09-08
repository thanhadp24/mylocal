package immutable;

public class Ex02BestPractice {
	private static final int N = 100000;
	public static void main(String[] args) {
		// Best Practice ==> 100% literal
		long start = System.currentTimeMillis();
		for(int i = 1; i <= N; i++) {
			String l1 = "hello";
			String l2 = "hello";
		}
		long end = System.currentTimeMillis();
		System.out.println("duration: " + (end-start) + "ms");
		// Stack: 100
		// HEAP: 1
		
		start = System.currentTimeMillis();
		for(int i = 1; i <= N; i++) {
			String o1 = new String("hello");
			String o2 = new String("hello");
		}
		end = System.currentTimeMillis();
		System.out.println("duration: " + (end-start) + "ms");
		// Stack: 100 
		// HEAP: 100 --> redundant memory for duplicate value
	}
}
