package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-28 22:41
 */
public class exercise412_FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i %3 == 0 && i%5 ==0) {
                list.add("FizzBuzz");
            }else if (i%3 == 0 ){
                list.add("Fizz");
            }else if (i%5 == 0) {
                list.add("Buzz");
            }else {
                list.add(i + "");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
