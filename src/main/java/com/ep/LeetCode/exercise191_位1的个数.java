package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-06 10:03
 */
public class exercise191_位1的个数 {

    // 方法一 循环检查二进制位
    // 00000000000000000000000000001011
    // 00000000000000000000000000000001
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }

    // 方法二 位运算优化
    // 00000000000000000000000000001011 (n)
    // 00000000000000000000000000001010 (n-1)
    // 00000000000000000000000000001010 n & n-1 两者相与会去掉一个1
    // 00000000000000000000000000001001 // n-1
    public int hammingWeight2(int n) {
        int res = 0;
        while(n != 0) {
            n &= n-1;
            res++;
        }
        return res;
    }
}
