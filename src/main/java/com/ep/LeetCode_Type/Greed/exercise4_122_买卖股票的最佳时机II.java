package com.ep.LeetCode_Type.Greed;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-23 10:01
 */
public class exercise4_122_买卖股票的最佳时机II {
    public static int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i-1], 0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
