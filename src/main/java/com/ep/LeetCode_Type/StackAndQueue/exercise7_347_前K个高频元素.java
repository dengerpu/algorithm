package com.ep.LeetCode_Type.StackAndQueue;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-21 10:41
 */
public class exercise7_347_前K个高频元素 {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i],0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer,Integer> entry : entries) {
           queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1}; int k = 1;
        int[] ints = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
