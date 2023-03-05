package com.ep.lanqiao;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-04 22:21
 */
public class exercise_10_1_立方和 {
    public static void main(String[] args) {
        int n = 2019;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i);
            if (s.indexOf('2')!= -1 || s.indexOf('0')!= -1 || s.indexOf('1')!= -1 ||s.indexOf('9')!= -1) {
                sum += Math.pow(i,3);
            }
        }
        System.out.println(sum);
    }
}
