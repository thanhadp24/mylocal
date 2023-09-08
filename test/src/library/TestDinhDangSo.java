package library;

import java.text.DecimalFormat;

public class TestDinhDangSo {
	public static void main(String[] args) {
		DecimalFormat dcf = new DecimalFormat("#.###");
		float a = 5.0f / 3;
		System.out.println("a = " + dcf.format(a));
	}

}
