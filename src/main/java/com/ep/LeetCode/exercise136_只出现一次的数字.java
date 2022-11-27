package com.ep.LeetCode;

import java.util.HashMap;
import java.util.Map;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-27 10:18
 */
public class exercise136_只出现一次的数字 {
    // 位运算，异或相同为0，相异为1，0和任何数异或都是本身
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }

    public static int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer integer = map.get(nums[i]);
                integer++;
                map.put(nums[i],integer);
            } else {
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }
}
