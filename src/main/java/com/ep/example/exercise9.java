package com.ep.example;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * 调整数组顺序使奇数位于偶数前面
 */
public class exercise9 {
    public static void main(String[] args) {
        int[] arr= {1,3,6,2,4,5,8,9,7,4,5,3};
        f(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    static void f(int[] arr, int p, int r) {
        int left = p;
        int right = r;
        while(left < right) {
            if (!isEven(arr[left])) {  // 奇数
                left++;
                continue;
            }
           if (isEven(arr[right])) { // 偶数
               right--;
               continue;
           }
           swap(arr, left, right);
           left++;
           right--;
        }
    }

    /***
     * 交换
     * @param arr
     * @param p
     * @param r
     */
    static void swap(int arr[], int p, int r) {
        int t = arr[p];
        arr[p] = arr[r];
        arr[r] = t;
    }

    /***
     * 判断是否是偶数
     * @param p
     * @return
     */
    static Boolean isEven(int p) {
        return (p&1) == 0;
    }
}
