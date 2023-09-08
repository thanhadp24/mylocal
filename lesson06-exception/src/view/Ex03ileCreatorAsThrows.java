package view;

import java.io.File;
import java.io.IOException;

public class Ex03ileCreatorAsThrows {
	public static void main(String[] args) {
		try {
			boolean isSuccess = creatorFile("hi.txt");
			System.out.println("is success: " + isSuccess);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean creatorFile(String filename) throws IOException  {
		File file = new File(filename);
 
		// bắt buộc khi gọi hàm createNewFile --> phải xử lí lỗi
		// try/catch || throw/throws
		 
		// require to process(try/catch/throw/throws) at calling place

		return file.createNewFile();
	}
	
	// public boolean createNewFile() throws IOException
}
