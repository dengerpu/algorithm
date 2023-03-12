package com.ep.LeetCode_Type.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-12 9:34
 */
public class exercise8_18_四数之和 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 排序后的第一个结果如果大于target，就没有结果（应该去掉）
//            if (nums[i] > target) return result;
            // 去重a
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < n; j++) {
                // 去重b
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j +1, right = nums.length - 1;
                while (right > left) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if ( sum > target) {
                        right --;
                    } else if (sum < target) {
                        left++;
                    }else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        // 对c和d去重
                        while (right > left && nums[left] == nums[left+1]) left++;
                        while (right > left && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000}; int target = -294967296;
        List<List<Integer>> lists = fourSum(nums,target);
        for (List<Integer> list:lists) {
            System.out.println(list);
        }
//        long res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            res+=nums[i];
//        }
//        System.out.println(res);
    }
}
