package com.ep.LeetCode_Type.Greed;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-25 9:13
 */
public class exercise6_45_跳跃游戏II {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // 记录当前覆盖的最大区域
        int curDistance = 0;
        // 最大的覆盖区域
        int maxDistance = 0;
        // 记录最大的跳跃次数
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // 在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(i + nums[i], maxDistance);
            if (maxDistance >= nums.length - 1) {
                ans++;
                break;
            }
            if (i == curDistance) {
                curDistance = maxDistance;
                ans++;
            }
        }
        return ans;
    }

    public int jump2(int[] nums) {
        int result = 0;
        // 当前覆盖的最远距离下标
        int end = 0;
        // 下一步覆盖的最远距离下标
        int temp = 0;
        for (int i = 0; i <= end && end < nums.length - 1; i++) {
            temp = Math.max(temp, i + nums[i]);
            if (i == end) {
                end = temp;
                result++;
            }
        }
        return result;
    }
}
