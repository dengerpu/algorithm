package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-05 9:52
 */
public class exercise6_131_分割回文串 {
    static List<String> path;
    static List<List<String>> res;
    public static List<List<String>> partition(String s) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        backTracking(s,0);
        return res;
    }
    // 1.确定参数和返回值
    public static void backTracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // startIndex相当于是切割线
        for (int i = startIndex; i < s.length(); i++) {
            // 如果是回文字符串，则记录
            if (isHuiWen(s, startIndex, i)){
                path.add(s.substring(startIndex, i+1)); // 截取左闭右开
            } else {
                continue;
            }
            // 起始位置后移，保证不重复
            backTracking(s, i+1);
            path.remove(path.size() - 1);
        }

    }

    // 判断你是否是回文
    public static Boolean isHuiWen(String s, int left, int end) {
        if (left == end) return true;
        int i, j;
        for ( i = left, j = end ; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="cdd";
        List<List<String>> partition = partition(s);
        System.out.println(partition);
    }
}
