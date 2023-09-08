package datetime.exercises;

import java.util.Calendar;

public class Ex02DatesInMonthYear {
	public static void main(String[] args) {
		// dates in month

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, Calendar.FEBRUARY);

		int datesInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("dates in month --> " + datesInMonth);

		int datesInYear = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("dates in year --> " + datesInYear);
		
		int dates = cal.getMinimum(Calendar.HOUR_OF_DAY);
		System.out.println(dates);
	}
	
	// phân biệt được maximum vs actualMaximum
}
