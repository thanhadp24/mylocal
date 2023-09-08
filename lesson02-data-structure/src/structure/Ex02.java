package structure;

public class Ex02 {
	// global variable --> attribute (thuộc tính)
	// use of any function in class Ex02 and also Ex02's external
	// public : access modifier : được dùng ở mọi nơi
	// private : only use in own class
	// static --> class's scope
	// non - static --> object's scope . Để gọi biến này cần phải tạo đối tượng từ
	// class rồi truy cập biến non-static (new class_name(). var_name)
	public static int age = 25;

	public static void main(String[] args) {
		// local variable --> block scope
		// data type :
		// + Primitive type ==> gtri lưu trữ ở stack
		int year = 1998;

		System.out.println("year: " + year);

		demo();
		
		int age = 24;
		int salary = 24;
		
		age = 28;		
		salary = age;	
		salary = 32;	
		
		System.out.println("age: " + age);		  //28
		System.out.println("salary: " + salary);  //32
		// + object type
	}

	// format code -> ctrl shift f
	public static void demo() {
		System.out.println("age: " + age);
	}
}
