package view;

public class Ex02MissingElementSecondWay {
	public static void main(String[] args) {
		int[] numbers = { 3, 2, 1, 6, 5 };
		System.out.println("missing element: " + findMissingNumber(numbers));
	}
	
	private static int findMissingNumber(int[] numbers) {
		int sum = ((numbers.length + 1)*(numbers.length + 2))/2;
		int sum1 = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum1 += numbers[i];
		}
		return sum-sum1;
	}
}
 