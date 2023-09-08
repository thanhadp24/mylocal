package utils;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import common.DayOfWeeks;

public class DateUtils {
	private static GregorianCalendar gregorianCalendar = new GregorianCalendar();
	private static DayOfWeeks[] dayOfWeeks = DayOfWeeks.values();

	private DateUtils() {
	}

	public static String optional (long dmy, String unit) {
		return  dmy > 0 ? dmy + " " + unit + " " : "";
	}
	
	public static boolean isHoliday(Calendar checkedCal, Calendar[] holidays) {
		int dayOfMonth = checkedCal.get(Calendar.DAY_OF_MONTH);
		int month = checkedCal.get(Calendar.MONTH);

		for (Calendar holiday : holidays) {
			if (dayOfMonth == holiday.get(Calendar.DAY_OF_MONTH) && month == holiday.get(Calendar.MONTH)) {
				return true;
			}
		}
		return false;
	}

	public static String format(String pattern, Calendar c) {
		return new SimpleDateFormat(pattern).format(c.getTime());
	}

	public static boolean isLeapYear(int year) {
		return gregorianCalendar.isLeapYear(year);
	}

	public static Calendar getInstance(int date, int month, int year, int hour, int minute, int second) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, date, hour, minute, second);
		return c;
	}

	public static Calendar getInstance(int date, int month, int year) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, date);
		return c;
	}

	public static Calendar getInstance(int month, int year) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		return c;
	}

	public static Calendar getTime(int date, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, date);
		c.set(Calendar.MONTH, month);
		return c;
	}

	public static DayOfWeeks getWdAsVNmese(Calendar c) {
		int dowAsInt = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeeks[dowAsInt - 1];
	}

	public static String between(Calendar start, Calendar end) {
		if (start.after(end)) {
			throw new IllegalArgumentException("start date cannot exceed end date !");
		}
		
		long duration = end.getTimeInMillis() - start.getTimeInMillis();
		
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration -= TimeUnit.DAYS.toMillis(days);
		
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.HOURS.toMillis(hours);
		
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		duration -= TimeUnit.MINUTES.toMillis(minutes);
		
		long second = duration/1000;
		
		return days + " days, " + hours + " hours, " + minutes + " minutes, " + second + " second: " ;
	}
}
