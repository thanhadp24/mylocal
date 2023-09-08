package structure;
// chú thích 1 dòng
// xóa 1 dòng dùng ctrl d
// run -> Debug : chạy tùng dòng code và xem từng dòng nó thực hiện như thế nào
			//  ==> breakpoint : điểm dừng của thèn Debug kích 2 lần vào vị trí mình muốn breakpoint

/**
 * chú thích nhìu dòng
 */
public class Ex01TestMainMethod {
	// main + ctrl +space
	public static void main(String[] args) {
		// start
		System.out.println("Welcome to java ");
		System.out.println("Today: lesson02-data-structure");
		
		anotherMain();
		
		System.out.println("age --> " + Ex02.age);
	}
	
	// method structure 
	// void : kiểu dữ liệu trả về
	// anotherMain : tên phương thức
	public static void anotherMain() {
		System.out.println("Another main method");
	}
}
