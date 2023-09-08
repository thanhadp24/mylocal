package test;

import java.util.Random;

public class Random1 {

	public static void main(String[] args) {
		Random rd = new Random();
		double x = rd.nextDouble()*10;// cố định trong khoảng [0,1)
		System.out.println(x);
	}
}
