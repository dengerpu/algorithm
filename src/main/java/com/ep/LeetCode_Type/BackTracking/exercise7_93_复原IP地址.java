package com.ep.LeetCode_Type.BackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-07 9:34
 */
public class exercise7_93_复原IP地址 {
    static List<String> res;
    public static List<String> restoreIpAddresses(String s) {
        res = new LinkedList<>();
        if (s.length() > 12) return res;
        backTracking(new StringBuffer(s),0,0);
        return res;
    }

    // 1.确定参数和返回值
    public static void backTracking(StringBuffer s, int startIndex, int pointSum) {
        // 2.终止条件
        if (pointSum == 3) {
            // 判断最后一个是否合法
            if (isValid(s, startIndex, s.length() - 1)) {
                res.add(s.toString());
            }
            return;
        }
        // 搜索遍历
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s.insert(i + 1, '.');
                pointSum++;
                backTracking(s, i + 2, pointSum);
                s.deleteCharAt(i+1);
                pointSum--;
            } else {
                break;
            }
        }

    }

    // 是否是合法的ip数字(左闭右闭)
    public static Boolean isValid(StringBuffer s, int start, int end) {
        if (end - start + 1 > 3) return false;
        if (start > end) return false;
        // 0 开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0000";
        System.out.println(restoreIpAddresses(s));
    }
}
