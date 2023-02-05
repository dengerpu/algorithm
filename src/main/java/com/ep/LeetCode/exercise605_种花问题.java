package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-05 16:51
 */
public class exercise605_种花问题 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if (length == 1 && flowerbed[0] == 1 && n == 1 ) {
            return false;
        }
        if (length == 1 && flowerbed[0] == 0 && n == 1) {
            return true;
        }
        int count = 0;
        if (length >= 2) {
            //最左侧情况
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                count ++;
                flowerbed[0] = 1;
            }
        }
        for (int i = 1; i < length - 1; i++) {
            // 中间的情况
            if (flowerbed[i-1] == 0 &&  flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        if (length >= 2) {
            // 最右侧情况
            if (flowerbed[length-2] == 0 && flowerbed[length-1] == 0) {
                count ++;
                flowerbed[length-1] = 1;
            }
        }
        return count >= n;
    }
    // 答案解法:
    public boolean canPlaceFlowers2(int[] flowerbed, int n ) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i /2;
                } else {
                    count += (i- prev -2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m+1) / 2;
        } else {
            count += (m - prev -1) / 2;
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0,0,1,0,1,0,0,0};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
