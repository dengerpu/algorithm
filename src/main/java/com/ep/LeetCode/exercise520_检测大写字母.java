package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-14 12:05
 */
public class exercise520_检测大写字母 {
    public static boolean detectCapitalUse(String word) {
        // 若第一个字母为小写，则需要额外判断第2个字母是否为小写
        if(word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        // 无论第一个字母是否大写，其他字母都必须与第2个字母的大小相同
        for (int i = 2; i < word.length(); i++) {
            // 异或相同为0， 相异为1
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "g";
        System.out.println(detectCapitalUse(word));
    }
}
