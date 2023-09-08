package datetime.exercises;

import java.util.Calendar;

import utils.DateUtils;

/**
 * a và b quen nhau từ 20/04/2020 10:20:30 hỏi a,b quen nhau được bao lâu tới
 * thời điểm hiện tại Ngày - giờ - phút - giây
 * 
 */
public class Ex07DatingTime {
	public static void main(String[] args) {
		
		Calendar start = DateUtils.getInstance(6, Calendar.JULY, 2023, 21, 30, 30);
		Calendar now = Calendar.getInstance();
		
		String duration = DateUtils.between(start, now);
		
		System.out.println(DateUtils.between(start, now));
	}
}
