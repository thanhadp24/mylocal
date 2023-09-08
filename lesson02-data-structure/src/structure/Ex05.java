package structure;

public class Ex05 {
	public static void main(String[] args) {
		// primitive type
		// + int, float, double, char --> stack
		// + lưu trữ được single value,giá trị đơn
		// + khởi tạo giá trị dùng =
		
		
		// object type
		// + object type có sẵn của java: String, Integer, Float,
		// + do mình tự tạo ra: Item, Employee,...
		// + khởi tạo giá trị dùng new tạo ra ô nhớ ở Heap
		
		// int vs Integer

		// int --> Stack,luôn có giá trị
		// --> lưu trữ
		// Integer --> Heap,có thể có giá trị hoặc NULL
		// --> lưu trữ , hỗ trợ các phương thức hữu ích

		char letter = 'B';
		System.out.println("letter: " + letter);
		
		// gọi hàm khởi tạo - constructor để khởi tạo đối tượng
		Character character = new Character('5');
		System.out.println("character: " + character);
		System.out.println("checking: " + character.isAlphabetic(character));
		
		String input = "1229";
		System.out.println("isNumber: " + input.matches("\\d+)"));
	}
}
