package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-09 9:55
 */
public class exercise495_提莫攻击 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i+1] - timeSeries[i] >= duration) {
                count += duration;
            }else {
                count += timeSeries[i+1] - timeSeries[i];
            }
        }
        count += duration;
        return count;
    }
    // 答案解法
    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] +duration - expired;
            }
            expired = timeSeries[i] + duration;  // 技能效果消失时间
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {1};
        int duration = 4;
        System.out.println(findPoisonedDuration(nums, duration));
    }
}
