package localdatetime;

import static utils.DateUtils.optional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import utils.DateUtils;

public class Ex04DateTimeDuration {
	public static void main(String[] args) {
		LocalDateTime dateTimeStart = LocalDateTime.of(2019, 8, 10, 10, 20, 30);
		LocalDateTime dateTimeEnd =   LocalDateTime.of(2020, 8,  8,  5, 10, 40);
		
		if (dateTimeStart.isAfter(dateTimeEnd)) {
			throw new IllegalArgumentException("date time start cannot exceed date time end !!!");
		}
		
		LocalDate dateStart = dateTimeStart.toLocalDate();
		LocalTime timeStart = dateTimeStart.toLocalTime();

		LocalDate dateEnd = dateTimeEnd.toLocalDate();
		LocalTime timeEnd = dateTimeEnd.toLocalTime();
		
		Period period = Period.between(dateStart, dateEnd);
		Duration duration = Duration.between(timeStart, timeEnd);
		
		if (timeStart.isAfter(timeEnd)) {
			period = period.minusDays(1);
			duration = duration.plusDays(1);
		}
		
		System.out.println(
						  optional(period.getYears(), "years") 
						+ optional(period.getMonths(), "months")
						+ optional(period.getDays(), "days") 
						+ optional(duration.toHoursPart(), "hours")
						+ optional(duration.toMinutesPart(), "minutes") 
						+ optional(duration.toSecondsPart(), "second"));

		System.out.println("================format==============");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(df.format(ldt));
		
		
	}
}
