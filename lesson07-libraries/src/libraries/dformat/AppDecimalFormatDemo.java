package libraries.dformat;

import java.text.DecimalFormat;
import java.util.Locale;

public class AppDecimalFormatDemo {
	public static void main(String[] args) {
		double value = 2342343943.944d;
		System.out.println("value: " + value);
		
		// Phần nguyên dùng dấu "," để ngăn cách
		// Phần âm dùng dấu "." để ngăn cách
		// 0, #: phần nguyên, phần thập phân
		//    ,: gom nhóm cho phần nguyên
		// 	  .: ngăn cách phần nguyên và phần thập phân

		// tiêu chuẩn--> : phần nguyên    --> # ,
		// 				   phần thập phân --> # 0 .
		
		Locale.setDefault(new Locale("da", "DK"));
		
		DecimalFormat df = new DecimalFormat("#,###.0000");
		
		System.out.println("formatted: " + df.format(value));
	}
}
