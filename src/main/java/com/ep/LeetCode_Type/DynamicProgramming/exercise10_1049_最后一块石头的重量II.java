package com.ep.LeetCode_Type.DynamicProgramming;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-21 10:12
 */
public class exercise10_1049_最后一块石头的重量II {
    public static int lastStoneWeightII(int[] stones) {
       int[] dp = new int[1501];
       int sum = 0;
       for (int i = 0; i < stones.length; i++) {
           sum += stones[i];
       }
       int target = sum / 2;
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(stones));
    }
}
