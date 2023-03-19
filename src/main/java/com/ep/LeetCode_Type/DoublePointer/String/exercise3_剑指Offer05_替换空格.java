package com.ep.LeetCode_Type.DoublePointer.String;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-13 9:29
 */
public class exercise3_剑指Offer05_替换空格 {
    public static String replaceSpace(String s) {
        String str = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') str += "%20";
            else str += arr[i];
        }
        return str;
    }

    //　双指针法
    public static String replaceSpace2(String s) {
        if (s.length() == 0 || s == null) return s;
        // 扩充容量，数组扩充2倍
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') str.append("  ");
        }
        // 若是没有空格直接返回
        if (str.length() == 0) return s;
        // 有空格情况，定义两个指针
        int left = s.length() - 1; // 左指针，指向原始字符串的最后一个位置
        s += str.toString();
        int right = s.length() - 1; // 右指针，指向扩展字符串的最后一个位置
        char[] chars =s.toCharArray();
        while (left >= 0) {
            if(chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace2(s));
    }
}
