package com.ep.LeetCode_Type.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-02 10:23
 */
public class exercise18_139_单词拆分 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int bagSize = s.length() + 1; // 背包容量
        Boolean[] dp = new Boolean[bagSize];
        dp[0] = true;
        for (int i = 1; i < bagSize; i++) {
            dp[i] = false;
        }

        for (int i = 1; i < bagSize; i++) { // 背包
            for (int j = 0; j < wordDict.size(); j++) { // 物品
                if (i >= wordDict.get(j).length() && dp[i - wordDict.get(j).length()] == true ) {
                    String word = s.substring(i - wordDict.get(j).length(), i);
                    if (word.equals(wordDict.get(j))) {
                        dp[i] = true;
                    }
                }
            }
        }
        return  dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList(new String[]{"apple", "pen"}));
        System.out.println(wordBreak(s, wordDict));
    }
}
