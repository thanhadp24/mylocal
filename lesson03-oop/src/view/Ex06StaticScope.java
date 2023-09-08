package view;

// internal
public class Ex06StaticScope {
	public static void main(String[] args) {
		add();
		//subtract();
		multiply();
		//divide();
	}
	// timing: static >> non-static
	
	// static --> static
	private static void add() {
		multiply();
		//divide();
	}
	// non --> static, non
	private void subtract() {
		multiply();
		divide();
	}

	private static void multiply() {

	}

	private void divide() {

	}
}
