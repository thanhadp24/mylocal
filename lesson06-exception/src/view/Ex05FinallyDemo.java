package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 *  B1 connect and open file
 *  B2 write file
 *  B3 Save file
 */
public class Ex05FinallyDemo {
	public static void main(String[] args) {
		File file = new File("data.txt");

		if (file.exists()) {
			writeData(file);
		}

		System.out.println("finished");
	}

	private static void writeData(File file) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write("hi all\n");
			fw.write("i would like to send the report as content below");

			fw.write("line 1\n");
			fw.write("line 2\n");
			fw.write("line 3\n");
			fw.write("line 4\n");
			fw.write("line 5\n");
			int value = 222 / 0; // Arithmetic exception
			fw.write("line k" + value + "\n");
			fw.write("line ....\n");
			fw.write("line 1000\n");

			fw.write("best regards\n");

		} catch (IOException | ArithmeticException e) {
			e.printStackTrace();
		} finally {
			// save and close file after writing
			// close database connection after query
			System.out.println("before closing");
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
