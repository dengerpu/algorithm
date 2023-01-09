package com.ep.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-09 10:36
 */
public class exercise496_下一个更大元素I {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length,j;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int k = 0;
            boolean flag = false;
            for (j = 0; j < nums2.length; j++) {
                if (a == nums2[j]) {
                    k = j;
                    flag = true;
                }
                if (flag && nums2[j] > a && j > k) {
                    arr[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) {
                arr[i] = -1;
            }
        }
        return arr;
    }

    // 答案解法： 方法一暴力
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int j = 0;
            // 先找到这个数
            while (j < n && nums2[j] != nums1[i]) {
                j++;
            }
            int k = j + 1;
            while (k < n && nums2[k] < nums1[i]) {
                k++;
            }
            res[i] = k < n ? nums2[k] : -1;
        }
        return res;
    }

    // 方法二：单调栈 + 哈希表
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        // 计算 nums2中每个元素右边的第一个更大的值；
        for (int i = nums2.length - 1; i >= 0 ; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() &&num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
       // 2 1 3
        int [] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        int[] ints = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
