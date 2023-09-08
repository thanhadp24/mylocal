package structure;

public class Ex11 {
	// 1.kiểm tra kí tự nhập vào có phải số không?
	// 2.kiểm tra chuối nhập vào có phải là số hay không?
	// ctrl + alt + down --> copy that line
	// case 1: tự build ra
	// case 2: dùng hàm có sẵn
	public static void main(String[] args) {
		char letter = '8';
		System.out.println(letter + " is digit ? --> " + isDigit(letter));
		System.out.println(letter + " is digit ? --> " + Character.isDigit(letter));

		System.out.println("\n====================\n");
		
		String sequence = "195k";
		System.out.println("is number --> " + isNumber(sequence));
		System.out.println("is number --> " + sequence.matches("\\d+"));
		// [0-9]: thoả mãn 1 kí tự bất kì từ 0-9
		// [0-9] <=> \d  "\\d"
		// {1,}: 1 hoặc nhiều kí tự
		// {1,} <=> +
		// ==> [0-9]{1,} <=> \\d+
		
		// thập phân: 123.434 regex = "\\d+.\\d+"
		// nếu số âm : "-?\\d+"
		
		// regex : stand for regular expression --> biểu thức chính quy là tập hợp các quy tắc, cú pháp cho chuỗi
	}
	// index(int)  0 1 2 3
	// value(char) 1 2 x 5
	private static boolean isNumber(String input) {
		for(int i = 0; i < input.length(); i++ ) {
			 char tmp = input.charAt(i);
			 if(!isDigit(tmp)) {
				 return false;
			 }
		}
		return true;
	}
	
	private static boolean isDigit(char input) {
		return (input >= '0' && input <= '9');
	}

}
