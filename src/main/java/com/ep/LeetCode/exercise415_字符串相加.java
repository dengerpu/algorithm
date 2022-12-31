package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-31 16:33
 */
public class exercise415_字符串相加 {
    public static String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 > n2) {
           return addStrings(num2, num1);
        }
        String newNum1 = "";
        for (int i = 0; i < n2-n1; i++) {
            newNum1 += "0";
        }
        newNum1 += num1;
        StringBuffer stringBuffer = new StringBuffer();
        int plus = 0; // 代表进位
        for (int i = n2-1; i >= 0 ; i--) {
            int a = Integer.parseInt(newNum1.charAt(i)+"");
            int b =  Integer.parseInt(num2.charAt(i)+"");
            int c = a+b + plus;
            if (c >= 10) {
                stringBuffer.append(c - 10);
                plus = 1;
            }else {
                stringBuffer.append(c);
                plus = 0;
            }
        }
        if (plus == 1) {
            stringBuffer.append(1);
        }
        return stringBuffer.reverse().toString();
    }

    // 答案方法：模拟
    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y +add;
            ans.append(result % 10);
            add = result/10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        System.out.println(addStrings(num1, num2));
    }
}
