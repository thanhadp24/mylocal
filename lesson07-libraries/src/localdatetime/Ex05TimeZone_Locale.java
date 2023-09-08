package localdatetime;

import java.util.Calendar;
import java.util.TimeZone;

public class Ex05TimeZone_Locale {
	public static void main(String[] args) {
		// Locale: khu vực
		// + Locale(country, language) --> firstDayOfWeek, currency(tiền tệ)
		
		
		// TimeZone: Múi giờ
		// TimeZone(zoneId) --> time at that zone
		
	
		TimeZone zone = TimeZone.getTimeZone("Europe/Berlin");
		
		Calendar now = Calendar.getInstance(zone);
		
		String nowAsString = now.get(Calendar.HOUR_OF_DAY) + "H " + now.get(Calendar.MINUTE)
													+ "M " + now.get(Calendar.SECOND) + "S";
		System.out.println(nowAsString);
		
	}
}
