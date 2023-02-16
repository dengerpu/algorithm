package com.ep.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-16 11:49
 */
public class exercise697_数组的度 {
    public int findShortestSubArray(int[] nums) {
        // 数组第一个值，出现的次数，第二个开始的索引，第三个值最后的索引
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1,i,i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }
}
