package view;

import java.util.Arrays;
import static java.util.Comparator.*;

public class Ex10Demo {
	public static void main(String[] args) {
		String[] sequences = {"blue", null, "yellow", "green", null, null, "red", "white", null};
	
		Arrays.sort(sequences, nullsFirst(comparing(seq->seq, reverseOrder())));
		System.out.println(Arrays.toString(sequences));
	}
}
