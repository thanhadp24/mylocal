package library;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {
	public static void main(String[] args) {
		// lấy ngày giờ hệ thống
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		System.out.println("current year: " + year);
		
		int month = cal.get(Calendar.MONTH); // month: 0--11
		System.out.println("current month: " + (month + 1));
		
		int day = cal.get(Calendar.DATE);
		System.out.println("current day: " + day);
		
		java.util.Date t = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(t));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(sdf2.format(t));
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aaa");
		System.out.println(sdf3.format(t));
	}
	
}
