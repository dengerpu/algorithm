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
        System.out.println(f3(arr));
        System.out.println(f4(arr));
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
    // 解法3：顺序统计
    static int f3(int[] arr) {
        return exercise10.selectK(arr,0,arr.length-1,arr.length/2);
    }
    // 解法4：不同的数，进行消除(原理，相邻两个元素，如果不同就消除)
    static int f4(int[] arr) {
        // 候选数
        int candidate = arr[0];
        // 出现的次数
        int nTimes = 1;
        // 扫描数组
        for (int i = 1; i < arr.length; i++) {
            // 两两消减为0，应该把现在的元素作为候选值
            if (nTimes == 0) {
                candidate = arr[i];
                nTimes = 1;
                continue;
            }
            // 遇到和候选值相同的，次数都加1
            if(arr[i] == candidate) {
                nTimes++;
            }else {
                // 不同的数，进行消减
                nTimes--;
            }
        }
        return candidate;
    }
}
