package com.ep.LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 */
public class exercise88_合并两个有序数组 {
    // 借助辅助空间 时间复杂度o(m+n) 空间复杂度o(n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int i = 0, j = 0, k = 0;
        while (i< m && j < n) {
            if (nums1[i]<= nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while (i < m) {
            arr[k++] = nums1[i++];
        }
        while (j < n) {
            arr[k++] = nums2[j++];
        }
       System.arraycopy(arr,0,nums1,0,k);
    }

    // 答案方法1 时间复杂度0(log(m+n))
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    // 答案方法2 双指针法 时间复杂度 o(m+n) 空间复杂度  o(m+n)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m+n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1+p2-1] = cur;
        }
        for (int i = 0; i != m + n ; i++) {
            nums1[i] = sorted[i];
        }
    }
    // 方法3 逆向双指针 时间复杂度 o(m+n) 空间复杂度  o(1)
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while(p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3,nums2,nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}
