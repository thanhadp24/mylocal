package structure;

// swap 2 số nguyên (int, Integer)
public class Ex08 {
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		
		// case 1 --> code in main method
		//a = b + 0*(b=a);
		
		swap(a, b);
		System.out.println(a);
		System.out.println(b);
	}
	
	// case 2 --> create a method for reusable
	// PASS BY VALUE 
	private static void swap(int f, int s) {
		int tmp = f;	
		f = s;
		s = tmp;
	}
}
