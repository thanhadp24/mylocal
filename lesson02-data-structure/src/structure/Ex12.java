package structure;

import bean.CustomInteger;
import bean.Item;

public class Ex12 {
	public static void main(String[] args) {
		// kiểu đối tượng
		
		// kiểu có sẵn: int , double, float,...
		int i = 7;
		Integer a = 5;
		Integer b = new Integer(55);
		
		// kiểu tự tạo:
		//CustomInteger c = 8;
		CustomInteger d = new CustomInteger(69);
		
		Item item = new Item(122, "abc", 1000);
	}
}
