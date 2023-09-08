package view;

import java.util.Arrays;
import java.util.function.Function;

import static java.util.Comparator.*;

public class Ex07ArraySortWithString {
	public static void main(String[] args) {
		String[] sequences = { "a", "b", "x", "z", "k" };

		// arrays.sort(object[] objects) --> auto descending
		// require: Object compatible with comparable
		// require: object implement comparable
		Arrays.sort(sequences);
		System.out.println("1st sorted sequences: " + Arrays.toString(sequences));

		Arrays.sort(sequences, (o1, o2) -> o1.compareTo(o2));
		System.out.println("2nd sorted sequences: " + Arrays.toString(sequences));

		Arrays.sort(sequences, comparing(seq->seq, reverseOrder()));
		System.out.println("2'nd sorted sequences: " + Arrays.toString(sequences));
		
		sequences = new String[] { "a", "b", null, "x", "z", null, "k" };
		// seq -> seq <--> function.identity()
		Arrays.sort(sequences, nullsLast(comparing(Function.identity(), reverseOrder())));
		// Arrays.sort(sequences, nullsFirst(reverseOrder()));
		System.out.println("3rd sorted sequences: " + Arrays.toString(sequences));
	}
}
