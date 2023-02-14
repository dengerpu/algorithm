package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-14 10:07
 */
public class exercise693_交替位二进制数 {
    // 方法一： 模拟
    public boolean hasAlternatingBits(int n) {
        int prev= 2;
        while (n != 0) {
            int cur = n % 2;
            if (cur == prev) {
                return false;
            }
            prev = cur;
            n/=2;
        }
        return true;
    }
    // 方法二： 位运算
    public boolean hasAlternatingBits2(int n) {
        int a = n ^ (n >> 1); // a的二进制位全为1
        return (a & (a + 1)) == 0;
    }
}
