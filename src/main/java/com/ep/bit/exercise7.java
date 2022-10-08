package com.ep.bit;

/***
 * @author dep
 * @version 1.0
 * 数组中只有一个数出现了1次，其他的数都出现了k次，请输出只出现了1次的数。
 */
public class exercise7 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,20,7,7,7,3,3,3,6,6,6,8,8,8};
        int len = arr.length;
        char [][] kRodix = new char[len][];
        int k = 3;
        int maxLen = 0;
        // 转成k进制字符串
        for(int i = 0; i < arr.length; i++){
            // 求每个数字的三进制字符串并翻转，然后转为字符数组
            kRodix[i] = new StringBuilder(Integer.toString(arr[i],k)).reverse().toString().toCharArray();
            if(kRodix[i].length > maxLen) {
                maxLen = kRodix[i].length;
            }
        }
        int[] resArr = new int[maxLen];
        for (int i = 0; i < len; i++) {
            // 不进位加法
            for (int j = 0; j < maxLen; j++) {
                if(j >= kRodix[i].length) {
                    resArr[j] += 0;
                } else {
                    resArr[j] += (kRodix[i][j] - '0');
                }
            }
        }
        int res = 0;
        for (int i = 0; i < maxLen; i++) {
             res += (resArr[i] % k) * (int)(Math.pow(k,i));
        }
        System.out.println(res);
    }
}
