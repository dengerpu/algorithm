package com.ep.LeetCode_Type.Greed;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-06 10:59
 */
public class exercise2_376_摆动序列 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int curDiff = 0; // 当前一对差值
        int preDiff = 0; // 前一对差值
        int result = 1; // 记录峰值个数，序列默认序列最右边一个峰值
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            // 出现峰值
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result ++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}
