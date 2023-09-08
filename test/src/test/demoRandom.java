package test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class demoRandom {
	private static String username = "admin";
	private static String password = "222";
	private static Random rd = new Random();
	private static String[] storage = new String[1000];
	
	public static void main(String[] args) {
		
		String userName = "admin";
		String passWord = "null";
		
		int breakLine = 1;
		int currentIndex = 0;
		do {
			passWord = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);
			if(isExists(storage, passWord, currentIndex)) {
				continue;
			}
			
			storage[currentIndex++] = passWord;
			
			sleep(100);
			System.out.print(passWord + " ");
			
			if(breakLine % 12 == 0) {
				System.out.println();
			}
			breakLine++;
		} while(!signIn(userName, passWord));
		System.out.println("\nđăng nhập thành công");
	}
	private static boolean isExists(String[] storage, String passWord, int currentValidIndex) {
		for(int i = 0; i < currentValidIndex; i++) {
			if(storage[i].equals(passWord)) {
				return true;
			}
		}
		return false;
	}
	
	private static void sleep(long millionseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(millionseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private static boolean signIn(String userName, String passWord) {
		return userName.equals(username) && passWord.equals(password);
	}
}
