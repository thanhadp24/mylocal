package localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static utils.DateUtils.*;

public class Ex02LocalTime {
	public static void main(String[] args) {
		LocalTime timeStart = LocalTime.now().withHour(10);
		System.out.println("timeStart " + timeStart);

		LocalTime timeEnd = LocalTime.of(12, 4, 10);
		System.out.println("timeEnd " + timeEnd);

		if (timeStart.isAfter(timeEnd)) {
			throw new IllegalArgumentException("time start cannot exceed time end !!!");
		}
		Duration duration = Duration.between(timeStart, timeEnd);
		System.out.println(duration);

		System.out.println("duration: " + optional(duration.toHoursPart(), "hours")
										+ optional(duration.toMinutesPart(), "minutes") 
										+ optional(duration.toSecondsPart(), "second"));
	
		System.out.println("================format==============");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("HH--mm--ss");
		LocalTime time = LocalTime.now();
		
		System.out.println("formatted: " + df.format(time));
		
		// String --> localtime
		LocalTime parseTime = LocalTime.parse("15--30--10", df);
		System.out.println("parseTime "+ parseTime);
	}
}
