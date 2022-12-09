package com.ep.LeetCode;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-08 11:38
 */
public class exercise219_存在重复元素2 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                int j = hashMap.get(nums[i]);
                if (i - j <= k) {
                    return true;
                }else {
                    hashMap.put(nums[i],i);
                }
            }else {
                hashMap.put(nums[i],i);
            }
        }
        return false;
    }

    // 答案方法一
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    // 方法二 滑动窗口
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i-k-1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
