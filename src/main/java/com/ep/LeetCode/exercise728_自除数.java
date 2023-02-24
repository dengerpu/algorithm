package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-24 9:08
 */
public class exercise728_自除数 {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int i = left; i <= right; i++) {
            flag = true;
            int sum = i;
            while (sum != 0) {
              int k = sum % 10;
              if (k == 0 || i % k != 0) {
                  flag = false;
                  break;
              }
              sum /= 10;
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int left = 47, right = 85;
        System.out.println(selfDividingNumbers(left, right).toString());
    }
}
