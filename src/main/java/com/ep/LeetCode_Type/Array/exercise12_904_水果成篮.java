package com.ep.LeetCode_Type.Array;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-03 8:51
 */
public class exercise12_904_水果成篮 {
    // 滑动窗口
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        for (right = 0; right < n; right++) {
            hashMap.put(fruits[right], hashMap.getOrDefault(fruits[right],0) + 1);
            while (hashMap.size() > 2) { // 长度大于2之后，也就是长度为3，要删除第一个
                // 必须一个一个减1，为0后移除（这样可以找到左侧的left）
                hashMap.put(fruits[left], hashMap.getOrDefault(fruits[left], 0) -1) ; // 删掉一个
                if (hashMap.get(fruits[left]) == 0){ // 如果为0，就删掉
                    hashMap.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }
}
