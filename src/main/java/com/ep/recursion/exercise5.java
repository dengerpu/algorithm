package com.ep.recursion;

/***
 * @author dep
 * @version 1.0
 * 在有空字符串的有序字符串数组中查找
 * 有个排序后的字符串数组，其中散布着一些空字符串，编写一个方法，找出给定字符串（肯定不是空字符串）的索引。
 */
public class exercise5 {
    public static void main(String[] args) {
        String[] strs = {"a","","ab","b","","cc","cd","dd"};
        String p = "cc";
        System.out.println(indexOf(strs, p));
    }
    static int indexOf(String[] arr, String p) {
        int begin = 0;
        int end = arr.length - 1;
        while(begin <= end) {
            int indexOfMid = begin + ((end - begin) >> 1);
            while(arr[indexOfMid].equals("")) {
                indexOfMid ++;
            }
            if(arr[indexOfMid].compareTo(p) > 0) {
                end = indexOfMid - 1;
            }else if(arr[indexOfMid].compareTo(p) < 0) {
                begin = indexOfMid + 1;
            } else {
                return indexOfMid;
            }
        }
        return -1;
    }
}
