package com.ep.lanqiao.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-08 9:01
 */
public class exercise1_特殊日期 {

    /***
     * 记一个日期为yy 年mm 月dd日，统计从2000年1月1日到|2000000年1月1日，
     * 有多少个日期满足年份yy是月份mm的倍数，同时也是 dd的倍数。
     * @param args
     */
    static int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        int ans = 1;
        int year = 2000000 - 1;
        for (int y = 2000; y <= year; y++) {
            for (int m = 1; m <= 12; m++) {
                int day = month[m];
                if(m == 2){
                    if((y % 100 != 0 && y % 4 ==0) || y % 400 == 0){
                        day++;
                    }
                }
                for (int d = 1; d <= day; d++) {
                    if((y % m == 0) && (y % d == 0)){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
