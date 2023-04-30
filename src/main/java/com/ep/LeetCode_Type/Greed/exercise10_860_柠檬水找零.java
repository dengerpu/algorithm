package com.ep.LeetCode_Type.Greed;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-30 9:53
 */
public class exercise10_860_柠檬水找零 {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five ++;
            }else if (bills[i] == 10) {
                ten++;
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                twenty++;
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
