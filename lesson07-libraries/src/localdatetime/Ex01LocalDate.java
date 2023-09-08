package localdatetime;

import java.time.LocalDate;
import java.time.Period;

import static utils.DateUtils.*;

public class Ex01LocalDate {
	public static void main(String[] args) {
		// todo: builder pattern
		LocalDate dateStart = LocalDate.now().withMonth(8).withYear(2022);
		System.out.println("dateStart: " + dateStart);

		LocalDate dateEnd = LocalDate.of(2024, 8, 7);
		System.out.println("dateEnd: " + dateEnd);

		if (dateStart.isAfter(dateEnd)) {
			throw new IllegalArgumentException("date start cannot exceed date end !!!");
		}

		Period period = Period.between(dateStart, dateEnd);
		System.out.println("period: " + period);

		System.out.println("period: " + optional(period.getYears(), "years") 
									  + optional(period.getMonths(), "months")
									  + optional(period.getDays(), "days"));
	}

}
