package view1;

/**
	A phrase is a palindrome if, after converting all uppercase letters 
	into lowercase letters and removing all non-alphanumeric characters, 
	it reads the same forward and backward. 
	Alphanumeric characters include letters and numbers.
	
	Given a string s, return true if it is a palindrome, or false otherwise.
	
	Example 1:
	
	Input: s = "A man, a plan, a canal: Panama"
	Output: true
	Explanation: "amanaplanacanalpanama" is a palindrome.
 */

public class Ex05ValidPalindrome {
	
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";

		System.out.println("valid palindrome --> " + isValidPalindrome(s));
	}
	
	private static boolean isValidPalindrome(String s) {
		s = s.trim().toLowerCase().replaceAll("[^0-9a-z]+", "");
		System.out.println("s after changed ->>" + s);
		int length = s.length();
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) != s.charAt(length - i -1)) {
				return false; 
			}
		}
		
		return true;
	}
}
