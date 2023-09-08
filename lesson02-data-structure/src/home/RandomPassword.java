package home;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomPassword {
	// system
	private static String username = "admin";
	private static String password = "024";
	// mảng: null, null, null,....
	private static String[] storage = new String[1000];
	private static Random rd = new Random();

	public static void main(String[] args) {
		String ipUserName = "admin";
		String ipPassword = null;

		int breakline = 1;
		int currentIndex = 0;
		do {
			ipPassword = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);

			if (isExists(storage, ipPassword, currentIndex)) {
				continue;
			}

			storage[currentIndex++] = ipPassword;
			// currentIndex++;

			sleep(50);
			System.out.print(ipPassword + " ");
			if (breakline % 12 == 0) {
				System.out.println();
			}
			breakline++;

		} while (!signIn(ipUserName, ipPassword));
		System.out.println();
		System.out.println("đăng nhập thành công!");
	}

	private static void sleep(long milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static boolean signIn(String ipUserName, String ipPassword) {
		return ipUserName.equals(username) && ipPassword.equals(password);
	}

	private static boolean isExists(String[] storage, String ipPassword, int currentValidIndex) {
		for (int i = 0; i < currentValidIndex; i++) {
			if (storage[i].equals(ipPassword))
				return true;
		}
		return false;
	}
}
