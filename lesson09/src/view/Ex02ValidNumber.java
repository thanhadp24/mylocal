package view;

import java.util.Arrays;

public class Ex02ValidNumber {
	public static void main(String[] args) {
		String[] numbers = getLargestNumber("aba23233hf3333ha", "232332afhd", "fah231af", "aba333g");
		for (String number : numbers) {
			System.out.println(number);
		}
	}

	private static String[] getLargestNumber(String... ss) {
		int maxLength = 1;
		int index = 0;
		int count = 1;
		int running = 0;
		String[] result = new String[ss.length];

		for (int i = 0; i < ss.length; i++) {
			String maxString = "";
			for (int j = 1; j < ss[i].length(); j++) {
				if (Character.isDigit(ss[i].charAt(j - 1))) {
					++count;
					if (count > maxLength) {
						maxLength = count;
						index = j - maxLength + 1;
						maxString = ss[i].substring(index, index + maxLength - 1);
					}
				} else {
					count = 1;
				}
			}
			result[running++] = maxString;
			maxLength = 1;
			index = 0;
			count = 1;
		}
		return Arrays.copyOfRange(result, 0, running);
	}
}
