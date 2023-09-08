package exercise;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex04YenNgua {
	public static void main(String[] args) {
		Random rd = new Random();
		Scanner ip = new Scanner(System.in);
		int M = ip.nextInt();
		int N = ip.nextInt();
		int[][] A = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = ip.nextInt();
			}
		}
		System.out.println("===============");
		print(A, M, N);
		System.out.println(check(A, M, N));
	}

	private static void print(int[][] a, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean check(int[][] a, int m, int n) {
	    int RowMinValue, ColMaxValue;
	    RowMinValue = ColMaxValue = a[0][0];
	    int indexRow = 0, indexCol = 0;
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (a[i][j] < RowMinValue) {
	                RowMinValue = a[i][j];
	                indexRow = i;
	            }

	            if (a[i][j] > ColMaxValue) {
	                ColMaxValue = a[i][j];
	                indexCol = j;
	            }
	        }
	    }
	    if (RowMinValue == ColMaxValue) {
	        return true;
	    }
	    return false;
	}

}
