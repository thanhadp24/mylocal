package structure;

// swap 2 số nguyên (int, Integer)
public class Ex07 {
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		
		// case 1 --> code in main method
		a = b + 0*(b=a);
		
		System.out.println(a);
		System.out.println(b);
	}
}
