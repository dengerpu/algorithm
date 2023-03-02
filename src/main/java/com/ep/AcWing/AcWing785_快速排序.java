package com.ep.AcWing;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-24 11:42
 */
public class AcWing785_快速排序 {

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // 30
        // 128 294 133 295 175 8 232 248 241 164 11 60 238 133 291 116 6 67 98 67 196 260 181 160 83 160 90 153 233 216
        quick_sort2(nums, 0, n - 1);
//        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (i != n-1) {
                System.out.print(nums[i] + " ");
            }else {
                System.out.println(nums[i]);
            }
        }
    }
    // 平均复杂度o(nlogn),超出时间限制
    public static void quick_sort(int[] arr, int left, int right) {
        if (right >= left) {
            // 保存基数
            int basic = arr[left];
            //定义左右指针
            int i = left;
            int j = right;
            while (i < j) { // 左指针小于右指针
                while (i < j && basic < arr[j]) { // 操作右指针找到小于基数的下标
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j]; // 将右指针对应小于基数的值放在左指针的位置
                    i++; // 左指针自加
                }
                while (i < j && basic > arr[i]) { // 操作左指针找到大于基数的下标
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i]; // 将左指针大于基数的值放在右指针的位置
                    j--;
                }
            }
            arr[i] = basic; // 将基数放在指针重合的位置
            quick_sort(arr, left, i - 1); // 对左半部分进行快速排序
            quick_sort(arr, i+1, right); // 对右半部分进行快速排序
        }
    }
    // 平均复杂度o(nlogn)
    public static void quick_sort2(int[] arr, int l, int r) {
        if(l >= r){
            return;
        }
        int x = arr[l + r >> 1],i = l - 1,j = r + 1;
        while(i < j){
            do{
                i++;
            }while(arr[i] < x);
            do{
                j--;
            }while(arr[j] > x);
            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        quick_sort(arr,l,j);
        quick_sort(arr,j+1,r);
    }
    public static void quickSort(int[] arr, int l, int r){
        if (l < r) {
            int q = partiotion(arr,l, r);
            quickSort(arr,l,q-1); // 左侧快速排序
            quickSort(arr,q+1,r); // 右侧快速排序
        }
    }
    public static int partiotion(int[] arr, int l, int r) {
        int pivot = arr[l];
        int left = l + 1; // 左指针
        int right = r; // 右指针
        while (left <= right) {
            if (left <= right && arr[left] <= pivot) left++;
            if (left <= right && arr[right] > pivot) right--;
            if (left < right) {
                swap(arr,left,right);
            }
        }
        // 循环退出时，right指向的最后一个小于等于主元的位置，也就是主元应该呆的位置
        swap(arr, l, right);
        return right;
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

    /***
     * 打印数组
     * @param arr
     */
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
