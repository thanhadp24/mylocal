package view;

import java.util.Arrays;

public class Ex03ValidNumbers {
	public static void main(String[] args) {
		String[] elements = { "a121ablaf24la23321", "23dfds238210adfds3423" };
		for (String element : elements) {
			String[] number = getValidNumber(element);
			int max = max(number);
			System.out.println(max);
		}
	}

	private static int max(String[] numbers) {
		int max = Integer.MIN_VALUE;
		for (String number : numbers) {
			if (max < Integer.parseInt(number)) {
				max = Integer.parseInt(number);
			}
		}
		return max;
	}

	private static String[] getValidNumber(String s) {
		String[] result = new String[s.length() / 2];
		int running = 0;
		StringBuilder sb = new StringBuilder();

		sb.append(Character.isDigit(s.charAt(0)) ? s.charAt(0) : "");
		for (int i = 1; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (Character.isDigit(letter)) {
				sb.append(letter);
				if (i == s.length() - 1) {
					result[running++] = sb.toString();
				}
			} else {
				if (Character.isDigit(s.charAt(i - 1))) {
					result[running++] = sb.toString();
					sb.delete(0, sb.length());
				}
			}
		}
		return Arrays.copyOfRange(result, 0, running);
	}
}
