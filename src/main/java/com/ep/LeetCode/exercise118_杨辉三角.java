package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-24 11:51
 */
public class exercise118_杨辉三角 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }else {
                    list.add(lists.get(i-1).get(j-1) + lists.get(i-1).get(j));
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate.toString());
    }
}
