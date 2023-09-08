package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Ex03DataManipulation {
	public static void main(String[] args) {
		// add, remove, set, contains, iterate, size, get
		List<String> elements = new ArrayList<>();

		elements.add("A");
		elements.add("B");
		elements.add("C");
		elements.add("D");

		// elements.remove(1);
		// elements.remove("C");

		 elements.removeIf(element -> element.compareTo("D") > 0);

		System.out.println("is exist: " + elements.contains("A"));
		
		System.out.println("size: " + elements.size());
		System.out.println(elements);

		// iterator
		
		iterate(elements);
		
	}
	
	private static void iterate(List<String> elements) {
		Iterator<String> each = elements.iterator();
		while (each.hasNext()) {
			String element = each.next();
			System.out.println(element);
		}
	}
}