package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-19 21:20
 */
public class exercise278_第一个错误的版本 {
    // 会超出时间限制
    public int firstBadVersion(int n) {
        for (int i = n; i > 0; i--) {
            if (!isBadVersion(i)) {
                return i+1;
            }
        }
        return 1;
    }
    public Boolean isBadVersion(int version){
        return true;
    }

    // 二分查找法
    public int firstBadVersion2(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + ((right-left) / 2);
            if (!isBadVersion(mid)) {
                left = mid+1;  // 答案在区间 [mid+1, right] 中
            } else {
                right = mid;  // 答案在区间 [left, mid] 中
            }
        }
        return left;
    }
}
