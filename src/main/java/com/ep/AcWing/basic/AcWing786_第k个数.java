package com.ep.AcWing.basic;

import java.io.IOException;
import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-02 12:21
 */
public class AcWing786_第k个数 {
    static int[] nums;
    static int k;
    public static void main(String[] args) throws IOException {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        quick_sort(nums,0, nums.length - 1);
    }
    public static void quick_sort(int[] arr, int l, int r) {
        if(l == r){
            System.out.println(arr[l]);
            return;
        }
        int x = arr[l + r >> 1],i = l - 1,j = r + 1;
        while(i < j){
            while (arr[++i] < x);
            while (arr[--j] > x);
            if(i < j) swap(arr,i, j);
        }
        if(j+1 >= k){
            quick_sort(arr,l,j);
        }else{
            quick_sort(arr,j+1,r);
        }
    }

    /***
     * 交换数组的值
     * @param arr
     * @param m
     * @param n
     */
    public static void swap (int[] arr, int m , int n) {
        int num = arr[m];
        arr[m] = arr[n];
        arr[n] = num;
    }
}
