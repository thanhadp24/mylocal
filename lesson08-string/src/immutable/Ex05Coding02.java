package immutable;

public class Ex05Coding02 {
	public static void main(String[] args) {
		String s = "today   is    a   good   day  ";
		String s1 = "day";
		
		// 1. kiểm tra chuỗi s1 có phải là chuỗi bắt đầu || kết thúc trong chuỗi s không
		System.out.println("is End: " + s.endsWith(s1));
		System.out.println("is start: " + s.startsWith(s1));
		
		// 2. thay thế chuỗi s1 bằng chuỗi s2 trong chuỗi s
		String s2 = "nice";
		System.out.println("s: " + s.replace(s1, s2));
		
		// 3. loại bỏ các khoảng trắng thừa s
		System.out.println("s after change: " + s.replaceAll("\\s+", " "));
		
		// 4. tạo chuỗi con s4 bắt đầu từ vị trí 2 từ s
		System.out.println("s4: " + s.substring(2));
		
		// 5. xác định chuỗi s2 có tồn tại trong chuỗi s1 ko4
		String s3 = "hello";
		System.out.println("s3 is exist in s: " + s.contains(s3));
	}
}
