package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-01 11:12
 */
public class exercise3_17_电话号码的字母组合 {
    static List<String> res;
    static StringBuffer path;
    static String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };
    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        path = new StringBuffer();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backTracking(digits,0);
        return res;
    }
    // 确定参数和返回值
    void backTracking(String digits,int index) {
        // 确定终止条件
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        Integer digit = digits.charAt(index) - '0';
        String letters = letterMap[digit];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backTracking(digits, index + 1);
            path.deleteCharAt(path.length() - 1); // 回溯
        }
    }
}
