package com.ep.LeetCode_Type.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-18 9:24
 */
public class exercise9_15_三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        for (int a = 0; a < n; a++) {
            // 排序后第一个数字大于0，后面的就不会有符合题意的答案了
            if (nums[a] > 0) return lists;
            // 对a进行去重。用nums[a-1] == nums[a]的好处就是，a已经在前面用过了
            if (a >= 1 && nums[a-1] == nums[a]) continue;
            int b = a + 1, c= n - 1;
            while (b < c) {
                int result = nums[a] + nums[b] +nums[c];
                if (result > 0) c--;
                else if (result < 0) b++;
                else {
                    lists.add(Arrays.asList(nums[a],nums[b],nums[c]));
                    // 对b和c进行去重
                    while (b < c && nums[b+1] == nums[b]) b++;
                    while (b < c && nums[c] == nums[c-1]) c--;
                    b++;
                    c--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }
}
