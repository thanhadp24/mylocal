package immutable;

public class Ex08FormatString {
	public static void main(String[] args) {
		// separator --> split
		String text = "wElcome ,-  To ,--@jaVA15 ! -Class";
		System.out.println(format(text));
		// require: first word's letter must be upper case, others will be lower case
		// output : Welcome To Java15 Class
	}

	private static String format(String text) {
		String formatted = "";
		// \\s{1,}
		// \\s+
		// [\\s,-]{1,}
		String[] words = text.split("[\\s,!-@]+");
		for (String word: words) {
			formatted += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " " ;
		}
		return formatted;
	}
}
