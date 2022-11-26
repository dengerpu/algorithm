package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-26 10:26
 */
public class exercise121_买卖股票的最佳时机 {

    // 这种方法超时了
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int max = max(prices, i+1);
            if (prices[i] > max) {
                continue;
            } else {
                if (maxProfit < max - prices[i]) {
                    maxProfit = max - prices[i];
                }
            }
        }
        return maxProfit;
    }

    public static int max(int[] arr, int start) {
        int max = arr[start];
        for (int i = start + 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    // 方法二
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
