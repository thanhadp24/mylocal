package view;

/*
 * cho 1 mảng từ [1,n] tìm phần tử bị thiếu
 * ex: int[] a = {2, 1,5,3} ==> 4
 */
public class Ex02GetMissingNumber {
	public static void main(String[] args) {
		int[] numbers = {1,4,2,6,3};
		System.out.println("the missing number is --> " + getMissingNumber(numbers));
		
	}

	private static int getMissingNumber(int[] numbers) {
		int sumAll = (numbers.length + 1) * (numbers.length + 2) / 2;
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}

		return sumAll - sum;
	}
}
