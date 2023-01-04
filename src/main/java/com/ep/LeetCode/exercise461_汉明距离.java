package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-04 10:58
 */
public class exercise461_汉明距离 {
    public static int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >> i & 1) ^ (y>> i & 1)) == 1) {
                count ++;
            }
        }
        return count;
    }
    // 方法一：内置位计数功能
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    // 方法二：移位实现位计数
    public int hammingDistance3(int x, int y) {
        int s = x ^ y ,ret = 0;
        while (s != 0) {
            ret += s&1;
            s>>=1;
        }
        return ret;
    }

    public int hammingDistance4(int x, int y) {
        int s = x ^ y, ret = 0;  // 相同为0，相异为1
        while (s != 0) {
            s &= s - 1;  //每次会去掉一个1
            ret++;
        }
        return ret;
    }
    public static void main(String[] args) {
        int x = 3, y = 1;
        System.out.println(hammingDistance(x, y));
    }

}
