package view1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
	Given two strings s and t, return true if t is an anagram of s, and false otherwise.

	An Anagram is a word or phrase formed by rearranging the letters of 
	a different word or phrase, typically using all the original letters exactly once.
	
	Example 1:
	
	Input: s = "anagram", t = "nagaram"
	Output: true
	Example 2:
	
	Input: s = "rat", t = "car"
	Output: false
 */

public class Ex06ValidAnagram {
	
	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";
		
		// System.out.println("is anagram: " + isValidAnagram(t, s));
		
		System.out.println(isValidAnagramWithHashMap(t, s));
	}
	
	private static boolean isValidAnagramWithHashMap(String t , String s) {
		// key: character, value: frequency
		Map<Character, Integer> count = new HashMap<>();
	
		for (char ch: t.toCharArray()) {
			count.put(ch, count.getOrDefault(ch, 0) + 1);
			//System.out.println(ch + " -> " + count.get(ch));
		}
		
		for (char ch: s.toCharArray()) {
			count.put(ch, count.getOrDefault(ch, 0) - 1);
			//System.out.println(ch + " -> " + count.get(ch));
			if (count.get(ch) == 0) {
				count.remove(ch);
			}
		}
		
		return count.isEmpty();
	}
	
	private static boolean isValidAnagram(String t, String s) {
		if (t.length() != s.length()) {
			throw new IllegalArgumentException("must be the same length");
		}
		
		String[] a = t.split("");
		Arrays.sort(a);
		
		String[] b = s.split("");
		Arrays.sort(b);
		
		return Arrays.equals(a, b);
	}
	
	
}	
