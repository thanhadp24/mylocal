package file.structure;

import java.io.File;
import java.io.IOException;

import utils.FileUtils;

public class Ex01FileCreator {
	private static String pathname = "storage" 
								+ File.separator + "data" 
								+ File.separator + "content.txt";
	public static void main(String[] args) {
		
		File file = FileUtils.createNewFile(pathname);
		
		/*
		File file = new File(pathname);
		if (!file.exists()) {
			try {
				boolean isCreated = file.createNewFile();
				System.out.println("isCreated: " + isCreated);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(file.getName() + " is existed");
		}
		*/
	}
	
}
