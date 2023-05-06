package com.ep.LeetCode_Type.Greed;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-06 12:42
 */
public class exercise16_738_单调递增的数字 {

    // 暴力破解，会超时
    // 判断数字的每一位是否递增
    public static boolean checkNumberIncrease (int num) {
        int max = 10; // 记录前一位数字（从后往前）
        while (num != 0) {
            int t = num % 10;
            if (max >= t) max = t;
            else return false;
            num /= 10;
        }
        return true;
    }
    public static int monotoneIncreasingDigits(int n) {
        for (int i = n; i >= 0; i--) {
            if (checkNumberIncrease(i)) {
                return i;
            }
        }
        return 0;
    }


    // 贪心算法
    public static int monotoneIncreasingDigits2(int n) {
        // 将数字转换为字符串
        String s = String.valueOf(n);
        char[] num = s.toCharArray();
        int flag = num.length; // flag用来标记赋值9从哪里开始
        for (int i = num.length - 1; i >= 1; i--) {
            if (num[i-1] > num[i]){ // 前一位数字比后一位数字大
                flag = i;
                num[i-1] = (char) (num[i-1] - 1);
            }
        }
        for (int i = flag; i < num.length; i++) {
            num[i] = '9';
        }
        return Integer.parseInt(String.valueOf(num));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits2(332));
    }
}
