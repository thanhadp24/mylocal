package structure;

import bean.Item;

public class Ex04 {
	public static void main(String[] args) {
		// Variables: age, price, letter, itemA;
		// ==> 100: biến lưu trữ, nằm ở stack
		
		// Values: 18,22.52,'X'
		//  ==> Primitive: Giá trị sẽ nằm ở stack
		//  ==> Object:    Giá trị sẽ nằm ở Heap
		//				   Giá trị null,chưa khởi tạo giá trị trên Heap
		// Primitive type
		int age = 18;
		double price = 22.52;
		char letter = 'X';
		System.out.println("Age: " + age);
		System.out.println("Price: " + price);
		System.out.println("Letter: " + letter);
		
		
		// Object type
		// new Item() --> khởi tạo đối tượng, ô nhớ ở Heap để lưu trữ giá trị
		Item itemA = new Item();
		itemA.itemId = 123;
		itemA.name = "Laptop Asus";
		itemA.price = 2200;
		 
		// khi gọi , in ra biến KDL đối tượng thì tự động nó sẽ gọi hàm toString của class 'Object'
		// Class Object : Mặc định là class cha của tất cả các class trong java
		// toString: giá trị, thông tin của đối tượng hiện tại
		
		// Nếu trong class Item define lại cái toString thì khi gọi nó sẽ gọi cái toString trong cái class Item đó.	
		System.out.println("ItemA: " + itemA);				
		//System.out.println("ItemA: " + itemA.toString());
		
		Item itemB = new Item();
		itemB.itemId = 234;
		itemB.name = "LG x234";
		itemB.price = 5200;
		System.out.println("itemB: " + itemB);
		
		Item itemC = new Item(567, "iphone", 6000);
		System.out.println("itemC: " + itemC);
		
	}
}
