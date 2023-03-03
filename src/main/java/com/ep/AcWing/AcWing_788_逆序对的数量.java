package com.ep.AcWing;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-03 14:44
 */
public class AcWing_788_逆序对的数量 {
    static int result = 0;
    public static void merge_sort(int[] nums, int l , int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        merge_sort(nums, l, mid);
        merge_sort(nums, mid + 1, r);
        int k = 0, i = l, j = mid + 1 ;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
                result += (mid - i + 1);
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (int m = 0; m < k; m++) {
            nums[m + l] = temp[m];
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        merge_sort(nums,0, n-1);
        System.out.println(result);
    }
}
