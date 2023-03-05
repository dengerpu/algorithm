package com.ep.lanqiao;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-04 22:28
 */
public class exercise_10_2_字串数字 {
    public static void main(String[] args) {
        String  s = "LANQIAO";
        char[] chars = s.toCharArray();
        int count = 0;
        long sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            Integer num = chars[i] - 64;
            sum += num * Math.pow(26, count++);
        }
        System.out.println(sum);
    }
}
