package datetime.exercises;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import common.DayOfWeeks;

public class Ex03WeekDayAsString {
	public static void main(String[] args) {
		// sunday(1), ....

		// String[] dowAsString = { "chủ nhật", "thứ 2", "thứ 3", "thứ 4", "thứ 5", "thứ 6", "thứ 7" };

		DayOfWeeks[] dayOfWeeks = DayOfWeeks.values();
		
		Calendar cal = Calendar.getInstance();
		cal.set(2023, Calendar.JULY, 6);
		int dowAsInt = cal.get(Calendar.DAY_OF_WEEK); // 1-7
		System.out.println(dowAsInt);
		
		System.out.println(dayOfWeeks[dowAsInt-1]);
	}
}
