package com.ep.recursion;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * 希尔排序
 */
public class shellSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void shellSort(int[] arr) {
        for (int interval = arr.length /2; interval >= 1 ; interval = interval / 2 ) {
            // 在增量为interval的插入排序
            for (int i = interval; i < arr.length; i++) {
                int target = arr[i];
                int j = i - interval;
                while (j > -1 && target < arr[j]) {
                    arr[j+ interval] = arr[j];
                    j-=interval;
                }
                arr[j+interval] = target;
            }
        }
    }
}
