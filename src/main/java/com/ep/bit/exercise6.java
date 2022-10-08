package com.ep.bit;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * 0~1间浮点实数的二进制表示
 */
public class exercise6 {
    /***
     * 给定一个介于O和1之间的实数，(如0.625)，类型为double,打印它的二进制表示(0.101,
     * 因为小数点后的二进制分别表示0.5,0.25.0.125......) 。
     * 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        StringBuilder stringBuilder = new StringBuilder("0.");
        while (num > 0) {
            // 乘以2
            double r = num*2;
            if(r >= 1) {
                stringBuilder.append("1");
                num = r-1;
            }else {
                stringBuilder.append("0");
                num  = r;
            }
            if(stringBuilder.length() > 34) {
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(stringBuilder.toString());

    }
}
