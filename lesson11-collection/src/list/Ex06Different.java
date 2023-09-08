package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex06Different {
	
	private static final int COUNT = 50000;
	
	public static void main(String[] args) {
		
		List<Integer> alist = new ArrayList<>();
		List<Integer> llist = new LinkedList<>();
		
		// add
		long start = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			alist.add(i);
		}
		System.out.println("Add array list --> " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			llist.add(i);
		}
		System.out.println("Add linkedlist --> " + (System.currentTimeMillis() - start));
		
		System.out.println("============");
		
		
		// add at index		
		start = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			alist.add(40000, i);
		}
		System.out.println("array list - add at index 49999 --> " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			llist.add(40000, i);
		}
		System.out.println("linked list - add at index 49999 --> " + (System.currentTimeMillis() - start));
	}
}
