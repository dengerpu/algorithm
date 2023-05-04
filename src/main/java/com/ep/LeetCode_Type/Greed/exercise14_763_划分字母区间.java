package com.ep.LeetCode_Type.Greed;

import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-04 9:19
 */
public class exercise14_763_划分字母区间 {
    public static List<Integer> partitionLabels(String s) {
        LinkedList<Integer> result = new LinkedList<>();
        int hash[] = new int[27];
        // 记录每个字母出现的最远位置
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if (i == right) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
