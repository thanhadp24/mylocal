package view1;

import java.util.HashSet;
import java.util.Set;

public class Ex12LongestSubWithoutRepeatin {
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(findLSWR(s));
	}
	
	private static int findLSWR(String s) {
		
		Set<Character> set = new HashSet<>();
		int left = 0;
		int max = 0;
		
		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			if (!set.contains(ch)) {
				set.add(ch);
				max = Math.max(max, right - left + 1);
			}else {
				while (set.contains(ch)) {
					set.remove(s.charAt(left++));
				}
				set.add(ch);
			}
		}
		
		
		return max;
		
	}
	
}
