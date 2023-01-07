package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-07 20:52
 */
public class exercise482_密钥格式化 {
    public static String licenseKeyFormatting(String s, int k) {
        int count = 0, m = s.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if(c == '-') {
                count++;
            }else {
                if ('a' <= c &&c <= 'z') {
                    stringBuffer.append((char)(c - 32));
                }else {
                    stringBuffer.append(c);
                }
            }
        }
        int n = stringBuffer.length();
        if (n <= k) {
            return stringBuffer.toString();
        }
        int d = n % k;
        if (d != 0) {
            stringBuffer.insert(d, '-');
            d++; // 加1的原因，字符串中加了一个字符
        }

        for (int i = d+k; i < n + n/k-1; i+=k) {
            stringBuffer.insert(i,'-');
            i++;
        }
        return stringBuffer.toString();
    }

    public String licenseKeyFaormatting(String s, int k) {
        StringBuffer ans = new StringBuffer();
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 &&ans.charAt(ans.length() -1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "2";
        int k = 2;
        System.out.println(licenseKeyFormatting(s, k));
    }
}
