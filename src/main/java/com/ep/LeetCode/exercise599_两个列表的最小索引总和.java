package com.ep.LeetCode;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-04 12:03
 */
public class exercise599_两个列表的最小索引总和 {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        int min = list1.length + list2.length - 2;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (map.get(list2[i]) + i < min) {
                    min = map.get(list2[i]) + i;
                }
            }
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i]) && map.get(list2[i]) + i == min) {
                arrayList.add(list2[i]);
            }
        }
        return arrayList.toArray(new  String[arrayList.size()]);
    }

    // 答案解法
    public String[] findRestaurant2(String[] list1, String[] list2) {
        HashMap<String, Integer> index = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }
        ArrayList<String> ret = new ArrayList<>();
        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (index.containsKey(list2[i])) {
                int j = index.get(list2[i]);
                if ( i + j < indexSum) {
                    ret.clear();
                    ret.add(list2[i]);
                    indexSum = i+j;
                } else if (i + j == indexSum) {
                    ret.add(list2[i]);
                }
            }
        }
        return ret.toArray(new String[ret.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] restaurant = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant));
    }
}
