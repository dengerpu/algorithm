package com.ep.LeetCode_Type.HashTable;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-10 10:00
 */
public class exercise5_454_四数相加II {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int temp = 0,count = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                hashMap.put(temp, hashMap.getOrDefault(temp, 0 ) + 1);
            }
        }
        for(int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (hashMap.containsKey(0 - temp)) {
                    count += hashMap.get(0-temp);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[]nums1 = {1}, nums2 = {-1}, nums3 = {0}, nums4 = {1};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
