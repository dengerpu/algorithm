package com.ep.LeetCode_Type.Greed;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-24 9:36
 */
public class exercise5_55_跳跃游戏 {
    public static boolean canJump(int[] nums) {
        int cover = 0;
        if(nums.length == 1) return true; //起初就位于第一个元素
        for (int i = 0; i <= cover; i++) {
           cover = Math.max(i + nums[i], cover);
           if (cover >= nums.length - 1) {
               return true;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
