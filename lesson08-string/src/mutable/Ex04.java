package mutable;

import java.util.Arrays;

import javax.swing.text.html.parser.Element;

public class Ex04 {
	public static void main(String[] args) {
		String[] numbers = getLargestNumber("aba234hfha", "232332afhd", "fah23laf", "aba333");
		System.out.println(Arrays.toString(getLargestNumber(numbers)));
	}

	private static String[] getLargestNumber(String... ss) {
		int maxLength = 1;
		int index = 0;
		int count = 1;

		String[] result = new String[ss.length];
		String maxString = "";
		for (int i = 0; i < ss.length; i++) {
			maxString = ss[i].substring(0, 1);
			for (int j = 0; j < ss[i].length(); j++) {
				if (Character.isDigit(ss[i].charAt(j))) {
					count++;
					if (count > maxLength) {
						maxLength = count;
						index = j - maxLength + 1;
						maxString = ss[i].substring(index + 1, index + maxLength);
					}
				} else
					count = 1;
			}
			result[i] = maxString;
			count = 1;
			index = 0;
			maxLength = 1;
		}
		return result;
	}

	


}
