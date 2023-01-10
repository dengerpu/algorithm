package com.ep.LeetCode;


import java.util.ArrayList;
import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-10 9:40
 */
public class exercise500_键盘行 {
    public static String[] findWords(String[] words) {
        ArrayList<String> arrayList = new ArrayList<>();
        String str1 = "qwertyuiop";
        String str2 = "asdfghjkl";
        String str3 = "zxcvbnm";
        for (String str: words) {
            int count = 1, n =str.length();
            if (n > 0) {
                if (str1.indexOf(str.charAt(0)) != -1 || str1.indexOf(Character.toLowerCase(str.charAt(0))) != -1) {
                    for (int i = 1; i < n; i++) {
                        if (str1.indexOf(str.charAt(i)) != -1 || str1.indexOf(Character.toLowerCase(str.charAt(i))) != -1) {
                            count ++;
                        }else {
                            break;
                        }
                    }
                    if (count == n) {
                        arrayList.add(str);
                    }
                }else if (str2.indexOf(str.charAt(0)) != -1 || str2.indexOf(Character.toLowerCase(str.charAt(0))) != -1) {
                    for (int i = 1; i < n; i++) {
                        if (str2.indexOf(str.charAt(i)) != -1 || str2.indexOf(Character.toLowerCase(str.charAt(i))) != -1) {
                            count ++;
                        }else {
                            break;
                        }
                    }
                    if (count == n) {
                        arrayList.add(str);
                    }
                }else if (str3.indexOf(str.charAt(0)) != -1 || str3.indexOf(Character.toLowerCase(str.charAt(0))) != -1) {
                    for (int i = 1; i < n; i++) {
                        if (str3.indexOf(str.charAt(i)) != -1 || str3.indexOf(Character.toLowerCase(str.charAt(i))) != -1) {
                            count ++;
                        }else {
                            break;
                        }
                    }
                    if (count == n) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] findWords2(String[] words) {
        ArrayList<String> arrayList = new ArrayList<>();
        // abcdefg每个字母所占的行号
        String rowIndex = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIndex.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 0; i < word.length(); i++) {
                if (rowIndex.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                arrayList.add(word);
            }
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public static void main(String[] args) {
        String[] words = {"adsdf","sfd"};
        System.out.println(Arrays.toString(findWords(words)));
    }
}
