package com.ep.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-31 11:54
 */
public class exercise414_第三大的数 {
    // 方法一 排序

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        int k = 1;
        // 1 2 3 4
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                k++;
            }
            if (k == 3) {
                return nums[i];
            }
        }
        // 没有第三大的数就返回最大的数
        return nums[0];
    }
    public static void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }

    // 方法二：有序集合
    public int thirdMax2(int[] nums) {
        TreeSet<Integer> integers = new TreeSet<>();
        for(int num : nums) {
            integers.add(num);
            if (integers.size() > 3) {
                integers.remove(integers.first());
            }
        }
        return integers.size() == 3 ? integers.first() : integers.last();
    }

    // 方法三： 一次遍历
    public int thirdMax3(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {  // 把 a换成最大的，b第二大，c第三大
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

    public static void main(String[] args) {
        int[] num = {-2147483648,1,1};
        System.out.println(thirdMax(num));
    }
}
