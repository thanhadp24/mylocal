package view;

import java.util.Arrays;
import java.util.List;

public class Ex07StreamOperation {
	public static void main(String[] args) {
		List<String> students = Arrays.asList("smith", "terry", "adam");
		
		students.stream()
				.filter(student -> {
					System.out.println("handling " + student);
					return student.length() == 5;
				}).toArray(String[]::new);
		
		
		System.out.println("finished..."	);
		
	}
}
