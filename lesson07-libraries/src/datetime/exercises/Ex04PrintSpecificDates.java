package datetime.exercises;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import utils.DateUtils;

public abstract class Ex04PrintSpecificDates {
	public static void main(String[] args) {
		// in ra các ngày trong tháng dd/MM/yyyy tên thứ
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy ");

		Calendar c = DateUtils.getInstance(Calendar.JULY, 2023);

		int datesInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int day = 1; day <= datesInMonth; day++) {
			c.set(Calendar.DAY_OF_MONTH, day);
			String formatted = df.format(c.getTime()) + " : " + DateUtils.getWdAsVNmese(c);
			System.out.println(formatted);
		}
		System.out.println("\n============\n");

		// in ra các ngày trong tuần
		Calendar now = Calendar.getInstance();
		now.set(2023, Calendar.JULY, 6);
		// FirstDayOfWeek = currentDates_number + fdow_number - currentWeekDates_number
		now.add(Calendar.DAY_OF_MONTH, now.getFirstDayOfWeek() - now.get(Calendar.DAY_OF_WEEK));

		System.out.println("first day of week: " + df.format(now.getTime()));

		for (int i = 1; i <= 7; i++) {
			String formatted = df.format(now.getTime()) + " : " + DateUtils.getWdAsVNmese(now);
			System.out.println(formatted);
			now.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}
