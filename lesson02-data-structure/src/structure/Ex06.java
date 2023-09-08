package structure;

import bean.Item;

public class Ex06 {
	public static void main(String[] args) {
		// final --> cannot update value at STACK
		final float PI = 3.14f; 
		
		// wrong update
		// PI = 4.
		final Item itemX = new Item(123, "Item123", 250);
		System.out.println("itemX address: " 
				+ System.identityHashCode(itemX));
		
		Item itemY = new Item(234, "Item234", 360);
		System.out.println("itemY address: " 
				+ System.identityHashCode(itemY));
		
		//itemX = itemY;
		System.out.println("itemX address: " 
				+ System.identityHashCode(itemX));
		
		itemX.name = "Updated Item";
		System.out.println(itemX);
	}
}
	