package operator;

public class Ex02Interview {
	public static void main(String[] args) {
		int count = 0;
		if(count > 0 && count++ > 1) {
			System.err.println("step 1: " + count++ ); // k in, count = 0
		}
		if(count >= 1 || ++count > 2) {
			System.err.println("step 2: " + count ); // k in, count = 1
		}
		if(count <= 2 && ++count >= 4) {
			System.err.println("step 3: " + count-- ); // k in ra,count = 2
		}
		System.err.println("step 4: " + count); // in ra count = 2
	}
}
