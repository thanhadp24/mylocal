package structure;

public class Ex03 {
	public static void main(String[] args) {
		int number = 18;
		
		//modified(number);
		
		int updated = update(number); 
		System.out.println("updated: " + updated);
	}
	
	// access modifier [static] return_type method_name (list of parameters).
	// pass by value
	// int input = number
	public static void modified(int input) {
		input = 99;
	}
	
	public static int update(int input) {
		input = 99;
		return input;
	}
}
