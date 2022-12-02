package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-02 11:28
 */
public class exercise171_excel表序列号 {

    public static int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int k =0;
        int result = 0;
        for (int i = n-1; i >= 0; i--) {
            int a = columnTitle.charAt(i) - 'A' + 1;
            result = result + (int)Math.pow(26, k) * a;
            k++;
        }
        return result;
    }

    // 减少幂运算次数
    public static int titleToNumber2(String columnTitle) {
        int n = columnTitle.length();
        int mlitiple = 1;
        int result = 0;
        for (int i = n-1; i >= 0; i--) {
            int a = columnTitle.charAt(i) - 'A' + 1;
            result = result + mlitiple * a;
            mlitiple *= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ZY";
        System.out.println(titleToNumber2(str));
    }
}
