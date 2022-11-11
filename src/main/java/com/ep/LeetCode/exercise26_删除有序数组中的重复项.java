package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 */
public class exercise26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if( n == 0) {
            return 0;
        }
        int fast = 1,slow = 1;
        while(fast < n ){
            // 后面的和前面的不相等
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
