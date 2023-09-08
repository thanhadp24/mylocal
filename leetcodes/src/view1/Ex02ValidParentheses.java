package view1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	An input string is valid if:
	
	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	Every close bracket has a corresponding open bracket of the same type.
	
	Input: s = "()[]{}"
	Output: true
	Example 3:
	
	Input: s = "(]"
	Output: false
 */
 
public class Ex02ValidParentheses {
	public static void main(String[] args) {
		String input = "[({})]";
		
		boolean isValidParentheses = isValidParentheses(input);
		System.out.println(isValidParentheses);
	}
	
	private static boolean isValidParentheses(String input) {
		
		Stack<Character> stack = new Stack<>();
		
		Map<Character, Character> match = new HashMap<>();
		match.put('}', '{');
		match.put(')', '(');
		match.put(']', '[');
		
		for (char ch: input.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				// System.out.println("letter: " + letter + " stack: " + stack);
			} else {
				if (stack.isEmpty() || stack.pop() != match.get(ch)) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
}
