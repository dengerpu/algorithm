package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-30 11:20
 */
public class exercise168_Excel表列名称 {
    public static String convertToTitle(int columnNumber) {
        StringBuffer stringBuffer = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber --;
            stringBuffer.append((char)((columnNumber % 26) + 'A'));
            columnNumber /= 26;
        }
        return stringBuffer.reverse().toString();
    }

    public static String convertTotitle(int columnNumber) {
        StringBuffer stringBuffer = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            stringBuffer.append((char)(a0-1+'A'));
            columnNumber = (columnNumber - a0) / 26;
         }
        return stringBuffer.reverse().toString();
    }


    public static void main(String[] args) {
        int num = 701;
        System.out.println(convertTotitle(num));
    }
}
