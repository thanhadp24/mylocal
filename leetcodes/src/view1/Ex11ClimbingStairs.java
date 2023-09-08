package view1;

/**
 	You are climbing a staircase. It takes n steps to reach the top.

	Each time you can either climb 1 or 2 steps. 
	In how many distinct ways can you climb to the top?
	
	Input: n = 2
	Output: 2
	Explanation: There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 step
	
	==> f(n) = f(n-1) + f(n-2)
 */

public class Ex11ClimbingStairs {
	public static void main(String[] args) {
		int n = 5;
		
		System.out.println(climbStairs(n));
	}
	
	private static int climbStairs(int n) {
		int[] dynamic = new int[100];
		dynamic[1] = 1; 
		dynamic[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			dynamic[i] = dynamic[i - 1] + dynamic[i - 2];
		}
		
		return dynamic[n];
	}
}
