package home;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomPasswordDemo {
	private static final String username = "admin";
	private static final String password = "123";
	private static Random rd = new Random();
	private static String[] storage = new String[1000];

	public static void main(String[] args) {
		String ipUsername = "admin";
		String ipPassword = null;
		
		int count = 0;
		do {
			ipPassword = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);
			if (isExist(storage, ipPassword, count))
				continue;
			
			storage[count++] = ipPassword;
			
			sleep(70);
			
			System.out.print(ipPassword + " ");
			
			if (count % 12 == 0) {
				System.out.println();
			}
			
			
		} while (!signIn(ipUsername, ipPassword));
		
		System.out.println("\nlog in successful!!!");
	}

	private static boolean isExist(String[] storage, String ipPassword, int currentLength) {
		for (int i = 0; i < currentLength; i++) {
			if (storage[i].equals(ipPassword))
				return true;
		}
		return false;
	}
	
	private static boolean signIn(String ipUsername, String ipPassword) {
		return ipUsername.equals(username) && ipPassword.equals(password);
	}
	
	private static void sleep(long milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
