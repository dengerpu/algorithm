package com.ep.example;


import org.lanqiao.algo.util.Util;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * 解决最小可用id问题： 在非负数组（乱序）中找到最小的可分配的id（从1开始编号）
 */
public class exercise12 {

    //  O(N²) 暴力解法:从1开始依次探测每个自然数是否在数组中
    static int find1(int[] arr) {
        int i = 1;
        while(true) {
            // 逐个进行查找
            if(Util.indexOf(arr, i) == -1) {
                return i;
            }
            i++;
        }
    }

    static int find2(int[] arr) {
        Arrays.sort(arr); // NlogN
        int i = 0;
        while (i< arr.length) {
            if (i+1 != arr[i]) { // //不在位的最小的自然数
                return i+1;
            }
            i++;
        }
        return i+1;
    }

    /**
     * 改进1：改用辅助数组
     * @param arr
     * @return
     */
   static int find3(int[] arr) {
        int N = arr.length;
        int[] helper = new int[N + 1];
       for (int i = 0; i < N; i++) {
           if ( arr[i] < N+1) {
               helper[arr[i]] = 1;
           }
       }
       for (int i = 1; i <=N ; i++) {
           if(helper[i] == 0) {
               return i;
           }
       }
       return N+1;
   }

   static int find4(int[] arr, int l ,int r) {
       if(l > r) {
           return l + 1;
       }
       int midIndex = l + ((r-l) >> 2); // 中间坐标
       int q = exercise10.selectK(arr, l, r, midIndex -l +1); // 实际在中间位置的值
       int t = midIndex + 1; // 期望值
       if( q== t ){ // 左侧紧密 （说明在右侧）
           return find4(arr, midIndex + 1, r);
       } else {
           return find4(arr,l, midIndex - 1);
       }
   }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 10, 11, 10000};
        arr = new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11};
        arr = new int[1000 * 1000];

        for (int i = 0; i < 1000 * 1000; i++) {
            if (i == 900000) {
                arr[i] = arr.length + 10;
            } else {
                arr[i] = i + 1;
            }
        }
        // arr = Util.getRandomArrWithoutRepetition(10, 1, 15);
        // Util.print(arr);
        long now = System.currentTimeMillis();
//        System.out.println(find2(arr));
//        Util.duration(now);


        now = System.currentTimeMillis();
        System.out.println(find3(arr));
        Util.duration(now);
//
//
        now = System.currentTimeMillis();
        System.out.println(find4(arr, 0, arr.length - 1));
        Util.duration(now);
    }
}
