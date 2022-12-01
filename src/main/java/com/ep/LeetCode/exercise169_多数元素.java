package com.ep.LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-01 21:47
 */
public class exercise169_多数元素 {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // 利用哈希表来统计每个元素的出现次数
    public static int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
               int a = hashMap.get(nums[i]);
               a++;
               hashMap.put(nums[i],a);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
           int key = entry.getKey();
           int value = entry.getValue();
           if (value > nums.length/2) {
               return key;
           }
        }
        return 0;
    }


    // 随机化
    private static int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    private static int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    public static int majorityElement3(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while(true) {
            int candidate = nums[randRange(rand,0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    // 分治
    private int countInRange(int[] nums,int num,int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    public int majorityElementRec(int[] nums,int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = (high - low) / 2 +low; // 中位数
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid + 1, high);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);

        return leftCount > rightCount ? left : right;

    }

    public int majorityElement4(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
    }
}
