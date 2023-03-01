package com.ep.LeetCode_Type.Array;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-01 9:46
 */
public class exercise9_844_比较含退格的字符串 {
    public static boolean backspaceCompare(String s, String t) {
        return getCharArray(s).equals(getCharArray(t));
    }
    public static String getCharArray(String s){
        char[] arr = s.toCharArray();
        int slow = 0, fast = 0;
        for (fast = 0; fast < arr.length; fast++) {
            if (arr[fast] == '#') {
                if (slow > 0) {
                    slow --;
                }
            }else {
                arr[slow] = arr[fast];
                slow++;
            }
        }
        return  new String(arr).substring(0, slow);
    }

    public static void main(String[] args) {
        String s = "a#c", t = "b";
        System.out.println(backspaceCompare(s, t));
    }
}
