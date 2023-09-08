package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex03Formatter {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		
		// date --> string
		Date date = new Date();
		System.out.println(df.format(date));
		
		// calendar --> string
		Calendar c = Calendar.getInstance();
		Date cDate = c.getTime();
		System.out.println(df.format(cDate));
		
		
	}
}
