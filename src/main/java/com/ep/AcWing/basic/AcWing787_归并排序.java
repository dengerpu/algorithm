package com.ep.AcWing.basic;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-02 14:19
 */
public class AcWing787_归并排序 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        merge_sort(nums,0, n-1);
        print(nums);

    }
    public static void merge_sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid =  l + r >> 1;
        merge_sort(arr,l, mid);
        merge_sort(arr, mid+1, r);
        int k = 0, i = l, j = mid +1 ;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        for (int m = 0; m < k; m++) {
            arr[m+l] = temp[m];
        }
    }
    public static void print(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i != n-1) {
                System.out.print(arr[i] + " ");
            }else {
                System.out.println(arr[i]);
            }
        }
    }
}
