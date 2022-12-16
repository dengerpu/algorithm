package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-16 11:29
 */
public class exercise258_各位相加 {
    public static int addDigits(int num) {
        while (true) {
            num = qiuhe(num);
            if (num < 10) {
                return num;
            }
        }
    }
    public static int qiuhe(int n) {
        int result = 0;
        while (n != 0) {
            result += n % 10;
            n/=10;
        }
        return result;
    }

    public int addDigits2(int num) {
        return (num-1) % 9 +1;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(0));
    }
}
