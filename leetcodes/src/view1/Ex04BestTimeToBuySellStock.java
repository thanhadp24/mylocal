package view1;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
 * and selling on day 1 is not allowed because you must buy before you sell.
 */

public class Ex04BestTimeToBuySellStock {
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		System.out.println("max profit --> " + maxProfit(prices));
	}

	private static int maxProfit(int[] prices) {

		int maxProfit = 0;
		int minPrice = prices[0];

		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			int profit = price - minPrice;
			maxProfit = Math.max(maxProfit, profit);
			System.out.println("min price: " + minPrice + " profit: " + profit + " max: " + maxProfit);
		}

		return maxProfit;
	}
}
