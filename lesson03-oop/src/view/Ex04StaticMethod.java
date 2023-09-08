package view;

public class Ex04StaticMethod {
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		
		//sum(a, b);
	}
	// static: not depends of calling object
	//		 : depends of class
	// non-static: depends on calling object
	// 1 hàm chỉ phụ thuộc vào tham số truyền vào --> static
	private int sum(int a, int b) {
		return a + b;
	}
}
