package view1;

/**
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Example 1:
 * 
 * Input: s = "babad" Output: "bab" 
 * Explanation: "aba" is also a valid answer.
 */

public class Ex14LongestPalindromeSubstring {
	public static void main(String[] args) {
		String s = "babad";

		System.out.println(findLongestPalindromeSubs(s));
	}

	private static String findLongestPalindromeSubs(String s) {
		String maxString = "", curString = "";
		int maxLength = 0, curLength = 0;

		for (int i = 0; i < s.length(); i++) {
			curString = expand(s, i, i);
			curLength = curString.length();

			if (maxLength < curLength) {
				maxLength = curLength;
				maxString = curString;
			}

			curString = expand(s, i, i + 1);
			curLength = curString.length();

			if (maxLength < curLength) {
				maxLength = curLength;
				maxString = curString;
			}
		}
		return maxString;
	}

	private static String expand(String s, int low, int high) {
		while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
			low--;
			high++;
		}
		return s.substring(low + 1, high);
	}
}
