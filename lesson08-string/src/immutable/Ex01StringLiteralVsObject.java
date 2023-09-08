package immutable;

public class Ex01StringLiteralVsObject {
	public static void main(String[] args) {
		// immutable: bất biến --> không thể cập nhật giá trị của ô nhớ ở HEAP
		// immutable --> literal(HEAP(constant pool)) & object

		String l1 = "hello";
		String l2 = "xin chao";
		String l3 = "hello";

		l1 = "welcome"; // H4

		hash("l1 hash", l1); // H1 H4
		hash("l2 hash", l2); // H2
		hash("l3 hash", l3); // H1

		System.out.println("================");

		String o1 = new String("language");
		String o2 = new String("text");
		String o3 = new String("language");
		hash("o1 hash", o1); // H11
		hash("o2 hash", o2); // H22
		hash("o3 hash", o3); // H33
	} 

	private static void hash(String text, String prop) {
		System.out.println(text + ": " + System.identityHashCode(prop));
	}
}
