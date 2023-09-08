package structure;

// swap 2 số nguyên (int, Integer)
public class Ex09 {
	public static void main(String[] args) {
		Integer a = new Integer(12);
		Integer b = 36;
		
		// case 1 --> code in main method
		//a = b + 0*(b=a);
	
		swap(a, b);
		System.out.println(a);
		System.out.println(b);
	}
	
	// case 2 --> create a method for reusable
	// PASS BY VALUE 
	private static void swap(Integer f, Integer s) {
		Integer tmp = f;	
		f = s;
		s = tmp;
	}
}
