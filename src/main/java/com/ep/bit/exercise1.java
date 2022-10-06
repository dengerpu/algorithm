package com.ep.bit;

import java.util.Random;

/***
 * @author dep
 * @version 1.0
 * 解题思路: 欧货相同为0,0和任何数异或都还得本身
 * a^b^c^a^b^c^d,利用交换律可以得到(a,a),(b,b),(c,c)异或为0,0和d异或就为d，这样就把d给找出来了
public
 */ class exercise1 {
    public static void main(String[] args) {
        int N = 1001;
        int[] arr = new int[N];
        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = i+1;
        }
        // 最后一个数，是随机数
        arr[arr.length -1] = new Random().nextInt(N-1) + 1;
        // 随机下标
        int index = new Random().nextInt(N);
        swap(arr,index, arr.length-1);
        print(arr);

        /**
         * 0异或任何数＝任何数
         * 1异或任何数－任何数取反
         * 任何数异或自己＝把自己置0
         * a^a=0；
         * a^0=a;
         * a^b=b^a，即交换律；
         */
        int x1 = 0;
        for (int i = 0; i <= N-1; i++) {
            x1 = (x1^i);
        }
        for (int i = 0; i < N; i++) {
            x1 = (x1^arr[i]);
        }
        System.out.println(x1);

        System.out.println("======================");
        // 方式二 暴力破解
        int helper[] = new int[N];
        for (int i = 0; i < N-1; i++) {
            helper[arr[i]]++;
        }
        for (int i = 0; i < N-1; i++) {
            if(helper[i] == 2) {
                System.out.println(i);
            }
        }

    }
    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
                System.out.print("[");
            }
            System.out.print(arr[i]);
            if(i < arr.length-1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}