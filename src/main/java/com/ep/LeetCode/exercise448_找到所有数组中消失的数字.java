package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-02 11:44
 */
public class exercise448_找到所有数组中消失的数字 {
    public  static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[nums[i]] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0){
                list.add(i);
            }
        }
        return list;
    }
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for(int num : nums) {
            int x = (num - 1 ) % n;
            nums[x] += n;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(Arrays.toString(disappearedNumbers.toArray()));
    }
}
