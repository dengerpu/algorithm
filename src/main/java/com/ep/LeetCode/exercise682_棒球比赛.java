package com.ep.LeetCode;

import java.util.ArrayList;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-13 11:15
 */
public class exercise682_棒球比赛 {
    public int calPoints(String[] operations) {
        int ret = 0;
        ArrayList<Integer> list = new ArrayList<>();
       for (String op : operations) {
           int n = list.size();
           switch (op.charAt(0)) {
               case '+':
                   ret += list.get(n-1) + list.get(n-2);
                   list.add(list.get(n-1) + list.get(n-2));
                   break;
               case 'D':
                   ret += 2*list.get(n-1);
                   list.add(2*list.get(n-2));
               case 'C':
                   ret -= list.get(n-1);
                   list.remove(n-1);
                   break;
               default:
                   ret += Integer.parseInt(op);
                   list.add(Integer.parseInt(op));
                   break;
           }
       }
       return ret;
    }
}
