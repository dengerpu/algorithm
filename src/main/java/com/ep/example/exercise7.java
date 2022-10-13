package com.ep.example;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 */
public class exercise7 {
    public static void main(String[] args) {
        int[] arr = {5,1,6,8,9,10,2,3,11};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] A, int p, int r) {
        if(p < r) {
            int q = partition2(A,p,r);
            quickSort(A,p,q-1); // 左侧快速排序
            quickSort(A,q+1,r); // 右侧快速排序
        }
    }
    public static int partition2(int[] arr, int p, int r) {
        // 优化，在p,r,mid之间，选一个中间值作为主元
        int midIndex = p + (((r-p))>>1); // 中间下标
        int midValueIndex = -1; // 中值的下标
        if(arr[p] <= arr[midIndex] && arr[p] >= arr[r]) {
            midValueIndex = p;
        }else if(arr[r] <= arr[midIndex] && arr[r] >= arr[p]) {
            midValueIndex = r;
        } else {
            midValueIndex = midIndex;
        }
        swap(arr, p, midValueIndex);
        int pivot = arr[p];
        int left = p + 1; // 扫描指针
        int right = r; // 右侧指针
        while(left <= right) {
            // left不停往右走，直到遇到大于主元的元素
            while(left <= right && arr[left] <= pivot) left++; // 循环退出时，left一定是指向第一个大于主元的位置
            while(left <= right && arr[right] > pivot) right--; // 循环退出时，right一定是指向最后一个小于等于主元素的
            if(left < right) {
                swap(arr, left, right);
            }
        }
        // while退出时，两者交错，且right指向的最后一个小于等于主元的位置，也就是主元应该呆的位置
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
