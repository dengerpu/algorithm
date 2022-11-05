package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 */
public class exercise9_回文数 {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * 示例 1：
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     */
    static boolean isPalindrome(int x) {
        String regStr = String.valueOf(x);
        StringBuffer reverse = new StringBuffer(regStr).reverse();
        if (regStr.equals(reverse.toString())) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPalindrome1(int x) {
        // 负数和10的整数倍不会是回文数
       if(x < 0 || (x % 10 == 0 && x != 0)) {
           return false;
       }
       int revertedNumber = 0;
       while (x > revertedNumber) {
           revertedNumber = revertedNumber * 10 + x % 10;
           x /= 10;
       }
       // 针对奇位数和偶位数的数字，分别判断是否为回文
       return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1(10));
        System.out.println(isPalindrome(10));
    }
}


