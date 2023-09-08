package view1;

import java.util.Arrays;

/**
 * An image is represented by an m x n integer grid image where image[i][j]
 * represents the pixel value of the image.
 * 
 * You are also given three integers sr, sc, and color. You should perform a
 * flood fill on the image starting from the pixel image[sr][sc].
 * 
 * To perform a flood fill, consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color), and so on. Replace the color of all of the
 * aforementioned pixels with color.
 * 
 * Return the modified image after performing the flood fill.
 * 
 *  Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
	Output: [[2,2,2],[2,2,0],[2,0,1]]
 */

public class Ex08FloodFill {

	public static void main(String[] args) {
		int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
	
		int[][] result = floodFill(image, 1, 1, 2);
		
		print(result);
	}

	private static void print(int[][] image) {
		for (int row = 0; row < image.length; row++) {
			for (int col = 0; col < image[row].length; col++) {
				System.out.print(image[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		// Avoid infinite loop if the new and old colors are the same...
		if (image[sr][sc] == color)
			return image;
		// Run the fill function starting at the position given...
		fill(image, sr, sc, color, image[sr][sc]);
		return image;
	}

	private static void fill(int[][] image, int sr, int sc, int color, int cur) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
			return;
		}

		if (cur != image[sr][sc]) {
			return;
		}

		image[sr][sc] = color;
		fill(image, sr - 1, sc, color, cur);
		fill(image, sr + 1, sc, color, cur);
		fill(image, sr, sc - 1, color, cur);
		fill(image, sr, sc + 1, color, cur);
	}
}
