package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 */
public class exercise14最长公共前缀 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * 提示：
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     */
    static String longestCommonPrefix(String[] strs) {
        int k = 0;
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string: strs) {
            while(!string.startsWith(s)) {
                if (s.length() == 0) return "";
                // 公共前缀不匹配就让它变短
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }
    // 方法二，横向扫描
    // 思路分析：第一个和第二个相比求出最长前缀，然后整个最长前缀再和后面的字符串相比得到新的最长前缀
    static String longestCommonPrefix2(String[] strs) {
        // 如果是空字符字符串数字直接返回空
        if (strs.length==0 || strs == null) return "";
        // 第一个字符串设为默认前缀
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = lcp(prefix, strs[i]);
            if(prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }
    static String lcp(String str1,String str2) {
        int length = str1.length() > str2.length() ? str2.length() : str1.length();
        int index = 0;
        while (index < length && (str1.charAt(index) == str2.charAt(index))) {
            index++;
        }
        return str1.substring(0,index);
    }

    // 方法三，纵向扫描
    static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0 ) return "";
        int length = strs[0].length();
        int count = strs.length;;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    // 方法四 分治法
    static String longestCommonPrefix4(String[] strs) {
        if( strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs,0,strs.length-1);
        }
    }
    static String longestCommonPrefix(String[] strs, int start,int end) {
        if(start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs,start,mid);
            String lcpRight = longestCommonPrefix(strs,mid+1,end);
            return lcp(lcpLeft,lcpRight);
        }
    }

    // 方法五 二分查找
    static String longestCommonPrefix5(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        // 求出最小的字符长度（公共前缀的长度肯定小于等于这个长度）
        for (String str: strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while( low < high) {
            int mid = (high - low +1) / 2;
            if(isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String[] strs2 = {"abc","flow","def"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix2(strs));
        System.out.println(longestCommonPrefix3(strs));
        System.out.println(longestCommonPrefix4(strs));
    }
}
