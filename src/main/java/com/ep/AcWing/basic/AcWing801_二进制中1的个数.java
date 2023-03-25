package com.ep.AcWing.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-17 10:49
 */
public class AcWing801_二进制中1的个数 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);
        String[] s1 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num =  Integer.parseInt(s1[i]);
            System.out.print(getBiteCount4(num) + " ");
        }
    }
    // 这种比较效率比较低
    static int getBiteCount(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num >> i & 1) == 1) count++;
        }
        return count;
    }
    // 比第一个稍微好点
    static int getBiteCount2(int num) {
        int count = 0;
        while (num != 0) {
            if(num % 2 == 1) count ++;
            num /= 2;
        }
        return count;
    }
    // 效率高
    static int getBiteCount3(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1); // 去掉最右边的1
            count++;
        }
        return count;
    }
    static int lowbit(int num) {
        return num & (-num);
    }
    static int getBiteCount4(int num) {
        int count = 0;
        while (num != 0) {
            num -= lowbit(num); // 去掉最右边的1
            count++;
        }
        return count;
    }
}
