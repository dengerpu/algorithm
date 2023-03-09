package com.ep.LeetCode_Type.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-09 12:44
 */
public class exercise2_349_两个数组的交集 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(map.get(nums1[i]),0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                if (!list.contains(nums2[i])) {
                    list.add(nums2[i]);
                }
                map.put(nums2[i],map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] ints = intersection(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
