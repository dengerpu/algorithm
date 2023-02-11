package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-11 11:25
 */
public class exercise674_最长连续递增序列 {
    public static int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int count = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if ( i+1 < n && nums[i] < nums[i+1]) {
                count++;
            }else {
                count = 1;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    // 答案解法：
    public int findLengthOfLCIS2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i-1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(findLengthOfLCIS(nums));
    }
}
