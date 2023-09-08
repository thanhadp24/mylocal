package mutable;

import bean.TrueSubstring;

public class Ex03Exercise {
	public static void main(String[] args) {
		String text = "aaabaabbbbaaaa";
		System.out.println(substring(text));
	}

	private static TrueSubstring substring(String text) {
		int index = 0;
		int longestLength = 1;
		String longestString = "";
		int count = 1;
		for (int i = 1; i < text.length(); i++) {
			if (text.charAt(i) == text.charAt(i - 1)) {
				count++;

				if (count > longestLength) {
					longestLength = count;
					index = i - longestLength + 1;
					longestString = text.substring(index, index + longestLength);
				}
			} else {
				count = 1;
			}
		}
		return new TrueSubstring(longestLength, index, longestString);
	}
}
