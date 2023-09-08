package list;

import java.util.ArrayList;
import java.util.List;

public class Ex02ArrayListWithSingleType {
	public static void main(String[] args) {
		// java 1.5 --> auto(boxing,unboxing)
		// int Integer, double Double...
//		int a = 10;
//		Integer b = a;	// --> boxing
//		a = b;	// --> unboxing
		
		// new ArraysList<>() --> length == empty
		//  this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
		// new ArrayList<>() --> first add --> elementData with length = default capacity
		// new ArrayList<>(20) --> first add --> elementData with length = input capacity
		// size: real elements in elementData
		List<Integer> numbers = new ArrayList<>();
		//int x = 5;
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		//numbers.add(x); // allow from java 1.5
		//numbers.add("4");
		// catch error at compile, better than raw type
		System.out.println(numbers.size());
	}
	// phân biệt giữa size và length 
}
