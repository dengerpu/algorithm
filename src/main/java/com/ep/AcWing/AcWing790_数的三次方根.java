package com.ep.AcWing;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-06 14:35
 */
public class AcWing790_数的三次方根 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x;
        x = scanner.nextDouble();
        double l = -1000, r = 1000;
        while (r - l > 1e-8) {
            Double mid = (l + r) / 2;
            if (mid*mid*mid >= x) r = mid;
            else l = mid;
        }
        System.out.println(String.format("%.6f",l));
    }
}
