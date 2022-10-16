package com.ep.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 * @author dep
 * @version 1.0
 * 超过一半的数字
 * //数组中出现次数超过半数的元素
 * 解法1:排序后返回arr[N/2]
 * 解法2: hash统计
 * 解法3:顺统计
 * 解法4:不同的数，进行消除
 */
public class exercise11 {
    public static void main(String[] args) {
        int []arr= {1,5,2,3,2,2,2};
        System.out.println(f(arr));
        System.out.println(f2(arr));
    }
    // 解法1:排序后返回arr[N/2]
    static int f(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
    // 解法2: hash统计
    static int f2(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                Integer count = hashMap.get(arr[i]);
                count++;
                hashMap.put(arr[i],count);
            }else {
                hashMap.put(arr[i],1);
            }
        }
        Set entrySet = hashMap.entrySet();
        for (Object entry: entrySet) {
            Map.Entry mapEntry = (Map.Entry) entry;
            if ((Integer)mapEntry.getValue() > arr.length / 2) {
                return (Integer) mapEntry.getKey();
            }
        }
        return -1;
    }
}
