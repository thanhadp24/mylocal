package localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex03LocalDateTime {
	public static void main(String[] args) {
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println("now: " + now);

		LocalDate date = now.toLocalDate();
		LocalTime time = now.toLocalTime();
		System.out.println("date: " + date);
		System.out.println("time: " + time);
		
		System.out.println("=====format&parse=======");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime parsedDateTime = LocalDateTime.parse("21/07/2023 10:10:21",df);
		System.out.println("parsedDateTime: " + parsedDateTime);
	}
}
