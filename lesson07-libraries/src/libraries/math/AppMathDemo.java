package libraries.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AppMathDemo {
	public static void main(String[] args) {
		
		// round, roundUp, roundDown, roundCommercial
		double value = 235.1638d;
		System.out.println("value: " + value);
		
		System.out.println("rounding: " + Math.round(value));
		System.out.println("rounding: " + Math.ceil(value));  // roundUp
		System.out.println("rounding: " + Math.floor(value)); // roundDown
		
		// big number, add, subtract, multiply, divide, rounding
		// BigInteger
		// BigDecimal
		
		System.out.println("==============");
		
		BigDecimal a = BigDecimal.valueOf(235.6364);
		BigDecimal b = BigDecimal.valueOf(123.236);
		
		a = a.setScale(1, RoundingMode.HALF_UP);
		
		BigDecimal result = a.multiply(a.add(b)).divide(b, 3, RoundingMode.HALF_UP);
				
		System.out.println("result: " + result);
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		// 123E^2
		double hugeValue = 1233454525425d;
		System.out.println("hugeValue: " + hugeValue);
		
		BigDecimal huge = BigDecimal.valueOf(hugeValue);
		System.out.println("huge: " + huge);
	}
}
