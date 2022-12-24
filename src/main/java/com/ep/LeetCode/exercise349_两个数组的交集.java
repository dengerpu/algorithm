package com.ep.LeetCode;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-24 11:12
 */
public class exercise349_两个数组的交集 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            integers.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (integers.contains(nums2[i])) {
                if (!list.contains(nums2[i])) {
                    list.add(nums2[i]);
                }
            }
        }
        int n = list.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    // 答案方法一：两个集合
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        for (int num: nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }
    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            // 长度小的放前面
            return getIntersection(set2,set1);
        }
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num: set1) {
            if (set2.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }
        return intersection;
    }

    // 答案解法二：排序加双指针
    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0,index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index-1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection,0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersection = intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
