package datetime.exercises;

import java.util.Calendar;

import common.Holiday;

import static utils.DateUtils.*;

/*
 today 7/6/2022 --> required hoàn thành trong 110days.Biết t7,cn và các 
 ngày nghỉ lễ ko tính ngày làm việc .Hỏi ngày mấy done  
 
 */
public class Ex06FindDeadLineDate {
	private static final int BUGET = 110;

	public static void main(String[] args) {
		int implementedDates = 0;

		Calendar c = getInstance(7, Calendar.JUNE, 2022);

		while (true) {
			int weekday = c.get(Calendar.DAY_OF_WEEK);
			boolean isDayOff = 
					weekday == Calendar.SUNDAY 
					|| weekday == Calendar.SATURDAY
					|| isHoliday(c, Holiday.getVNmeseHolidays());
			if (!isDayOff) {
				implementedDates++;
				if (implementedDates == BUGET) break;
			}
			c.add(Calendar.DAY_OF_MONTH, 1);
		}

		System.out.println("dead line: " + format("dd/MM/yyyy ", c));
	}
}
