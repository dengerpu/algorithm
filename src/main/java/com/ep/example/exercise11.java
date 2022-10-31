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
//        int []arr= {1,5,2,3,2,2,2};
        int []arr= {1,2,1,3,1,4,1};
        System.out.println(f(arr));
        System.out.println(f2(arr));
        System.out.println(f3(arr));
        System.out.println(f4(arr));
        System.out.println(f5(arr));
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

    /**
     * //变化，出现次数恰好为个数的一半，求出这个数
     * 关于加强版水王的题我有个想法可以扫描一遍数组就解决问题：
     * 水王占总数的一半，说明总数必为偶数；
     * 不失一般性，假设隔一个数就是水王的id，两两不同最后一定会消减为0
     * 水王可能是最后一个元素，每次扫描的时候，多一个动作，和最后一个元素做比较，单独计数，计数恰好等于一半
     * 如果不是，计数不足一半，那么去掉最后一个元素，水王就是留下的那个candidate
     * */
    static int f5(int arr[]) {
        // 候选数
        int candidate = arr[0];
        int nTimes = 0;
        int countOfLast = 0; // 统计最后这个元素出现的次数
        int N = arr.length;

        for (int i = 0; i < N; i++) {
            // 增加和最后一个元素比较的步骤
            if(arr[i] == arr[N-1]) countOfLast++;
            if(nTimes == 0) {
                candidate = arr[i];
                nTimes++;
                continue;
            }
            if(arr[i] == candidate) {
                nTimes++;
            }else {
                nTimes--;
            }
        }
        // 最后一个元素出现的次数是n/2
        if(countOfLast == N/2 ){
           return arr[N-1];
        }else {
           return candidate;
        }
    }
}
