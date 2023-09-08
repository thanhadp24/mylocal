package datetime.exercises;

import java.util.Calendar;

import utils.DateUtils;

public class Ex01LapYear {
	public static void main(String[] args) {
		int year = 2004;
		System.out.println(year + " is leap year --> " + DateUtils.isLeapYear(year));

	}
}
