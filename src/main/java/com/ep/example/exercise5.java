package com.ep.example;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * 快速排序
 */
public class exercise5 {
    public static void main(String[] args) {
        int[] arr = {5,1,6,8,9,10,2,3,11};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] A, int p, int r) {
        if(p < r) {
            int q = partition(A,p,r);
            quickSort(A,p,q-1); // 左侧快速排序
            quickSort(A,q+1,r); // 右侧快速排序
        }
    }
    public static int partition(int[] arr, int p, int r) {
        int pivot = arr[p];
        int scanner = p + 1; // 扫描指针
        int right = r; // 右侧指针
        while(scanner <= right) {
            if(arr[scanner] < pivot) {
                scanner ++ ;
            }else {
                // 找到左侧大的和右侧进行交换
                swap(arr, scanner, right);
                right--;
            }
        }
        swap(arr, p, right);
        return right;
    }

    /***
     * 交换数组的值
     * @param arr
     * @param m
     * @param n
     */
    static void swap (int[] arr, int m , int n) {
        int num = arr[m];
        arr[m] = arr[n];
        arr[n] = num;
    }
}
