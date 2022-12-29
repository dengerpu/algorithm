package com.ep.LeetCode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-28 10:59
 */
public class exercise401_二进制手表 {
    // 方法一：枚举时分
    public static List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m <10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
    // 方法二： 二进制枚举
    public static List<String> readBinaryWatch2(int turnedOn) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            int h = i >> 6, m = i & 63;  // 用位运算取出低6位和高4位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m <10 ? "0" : "") + m);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int turnedOn = 1;
        List<String> list = readBinaryWatch(turnedOn);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
