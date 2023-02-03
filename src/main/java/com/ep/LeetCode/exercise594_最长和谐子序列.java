package com.ep.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-03 11:47
 */
public class exercise594_最长和谐子序列 {
    // 方法一：枚举
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int res  = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin ++;
            }
            if (nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;
    }
    // 方法二：哈希表
    public int findLHS2(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res,cnt.get(key) + cnt.get(key+1));
            }
        }
        return res;
    }
}
