package com.ep.bit;

import java.util.Random;

/***
 * @author dep
 * @version 1.0
 */
public class exercise1 {
    public static void main(String[] args) {
        int N = 11;
        int[] arr = new int[N];
        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = i+1;
        }
        // 最后一个数，是随机数
        arr[arr.length -1] = new Random().nextInt(N-1) + 1;
        // 随机下标
        int index = new Random().nextInt(N);
        swap(arr,index, arr.length - 1 );
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}