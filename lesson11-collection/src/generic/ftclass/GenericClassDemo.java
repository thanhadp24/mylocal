package generic.ftclass;

public class GenericClassDemo {
	public static void main(String[] args) {
		IList<Integer> numbers = new CustomList<>();
		numbers.add(2); 
		numbers.add(5);
		numbers.add(8);
		numbers.add(1, 4);
		
		System.out.println("size: " + numbers.size());
		
		numbers.iterate(number -> System.out.print(number + " "));
		
		// System.out.println("\nlength: " + numbers.getCapacity());
		
		// do not support forEach
		// do not support iterate 
		
	}
}
