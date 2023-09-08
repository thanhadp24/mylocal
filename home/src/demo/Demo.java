package demo;

public class Demo {
	public static void main(String[] args) {
		A obj = new B();
		obj.show();

		// anonymous inner class
		A o1 = new A() {
			// still in java07
			@Override
			public void show() {
				System.out.println("hi java07");
			}
		};
		o1.show();

		// in java08
		A o2 = () -> {
			System.out.println("hi java08");
			System.out.println("helo");
		};
		o2.show();
	}
}
// vì functional interface --> only have 1 method
// thay vì phải tạo subclass B thì t có thể dùng funtional interface
