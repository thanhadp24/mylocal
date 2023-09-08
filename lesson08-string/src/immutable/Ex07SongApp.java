package immutable;

import java.util.Arrays;

public class Ex07SongApp {
	public static void main(String[] args) {
		// lấy danh sách các bài hát mp3

		String[] paths = {  "d:/music/shapeofyou.mp3", 
							"d:/music/allweknow.mp3", 
							"d:/music/onmyway.mov", 
							"d:/music/lethergo.mp3"
													};
		System.out.println(Arrays.toString(getSongNames(paths, ".mov")));
	}

	private static String[] getSongNames(String[] paths, String extension) {
		String[] result = new String[paths.length];
		int count = 0;

		for (String path : paths) {
			if (path.endsWith(extension)) {
				result[count++] = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}
}
