package file.structure;

import java.io.File;

public class Ex02DirCreator {
	private static String pathname = "structure\\data";
	public static void main(String[] args) {
		File dir = new File(pathname);
		if (!dir.exists()) {
			boolean isCreated = dir.mkdirs();
			System.out.println("is created: " + isCreated);
		}else {
			System.out.println(dir.getName() + " is existed");
		}
	}
}
