package com.ep.LeetCode_Type.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-11 11:11
 */
public class exercise7_15_三数之和 {
    // 双指针
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) return result;
            // a的去重
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                // 去重复逻辑如果放在这里，0，0，0 的情况，可能直接导致 right<=left 了，从而漏掉了 0,0,0 这种三元组
                // 去重
//                while (nums[left] == nums[left + 1]) left++;
//                while (nums[right] == nums[right - 1]) right--;
                if (nums[i] + nums[left] + nums[right] > 0) right --;
                else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    // 对b和c去重
                    while (nums[left] == nums[left + 1]) left++;
                    while (nums[right] == nums[right - 1]) right--;

                    // 找到答案，双指针同时收缩
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
