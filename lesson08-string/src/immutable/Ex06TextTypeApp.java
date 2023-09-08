package immutable;

import bean.StringCount;

public class Ex06TextTypeApp {
	public static void main(String[] args) {
		// đếm có bao nhiêu kí tự hoa, thường, số
		String s = "aBfEcD17562#@!";
		System.out.println(count(s));
	}
	
	private static StringCount count(String s) {
		int numOfUCLetters = 0;
		int numOfLCLetters = 0;
		int num = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num++;
			} else if (Character.isLowerCase(s.charAt(i))) {
				numOfLCLetters++;
			} else if (Character.isUpperCase(s.charAt(i))) {
				numOfUCLetters++;
			}
		}
		return new StringCount(numOfUCLetters, numOfLCLetters, num);
	//	return result;
	}
}
