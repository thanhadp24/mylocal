package immutable;

public class Ex04Coding01 {
	public static void main(String[] args) {
		String s = "JAVA15";
		String s1 = "COURSE";

		// 1.tính chiều dài chuỗi s
		System.out.println("1. length of s: " + s.length());

		// 2.Nối chuỗi s1 vào s
		System.out.println("2. s1 + s: " + s.concat(s1)); // tạo ô nhớ mới để lưu

		// 3.lấy 1 kí tự tại vị trí index(3) trong chuỗi s
		System.out.println("3. character at 3th: " + s.charAt(3));

		// 4.Duyệt từng phần tử trong chuỗi s
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + " ");
		}

		System.out.println();
		// 5.tìm vị trí - chỉ số xuất hiện đầu tiên - cuối cùng của kí tự a trong chuỗi s
		System.out.println("last index of a: " + s.lastIndexOf('A'));
		System.out.println("first index of a: " + s.indexOf('A'));
		

	}

}
