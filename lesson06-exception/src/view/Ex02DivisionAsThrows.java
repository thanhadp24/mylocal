package view;

public class Ex02DivisionAsThrows {
	public static void main(String[] args) {
		// cách 2.2: hậu xử lí(throw) --> xử lí khi xảy ra lỗi đảm bảo đoạn mã phía
		// sau vẫn được thực thi

		System.out.println("D1: " + divide(10, 5));
		System.out.println("D2: " + divide(10, 0));
		System.out.println("D3: " + divide(10, 2));

	}

	// no need to throws runtime exception --> unnecessery
	// not require to process(try/catch/throw/throws) at calling place
	
	private static int divide(int a, int b) throws ArithmeticException {
		return a / b;
	}

	/*
	 * Exception in thread "main" java.lang.ArithmeticException: / by zero at
	 * view.Ex02DivisionAsThrow.divide(Ex02DivisionAsThrow.java:15) at
	 * view.Ex02DivisionAsThrow.main(Ex02DivisionAsThrow.java:9)
	 */
}
