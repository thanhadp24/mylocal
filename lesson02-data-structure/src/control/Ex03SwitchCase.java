package control;

/**
 * Give a month as number ==> print number of days in given month
 */
public class Ex03SwitchCase {
	public static void main(String[] args) {
		int month = 3;
		int daysInMonth = -1;
		switch (month) {
		case 1,3,5,7,8,10,12:
			daysInMonth = 31;
			//break;
		case 2:
			daysInMonth = 28;
			break;
		case 4,6,9,11:
			daysInMonth = 30;
			break;
		default:
			System.out.println("Invalid month");
			return;
		}
		System.out.println("Số ngày trong tháng: " + daysInMonth);

	}
}
