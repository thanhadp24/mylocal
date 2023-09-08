package control;

/**
 * Ex02: tìm học lực học viên: getLevel(float point): Level bad, good,
 * pretty-good, medium
 *
 */
public class Ex02IfElseElseIf {
	public static void main(String[] args) {
		String level = getLevel(9.3f);
		System.out.println("level: " + level);
	}

	// Validate: 0 <= point <= 10
	private static String getLevel(float point) {
		String result = "";
		if (point < 5) {
			result = "Bad";
		} else if (point < 6.5) {
			result = "Medium";
		} else if (point < 8) {
			result = "Pretty-good";
		} else {
			result = "good";
		}
		return result; 
	}
}
