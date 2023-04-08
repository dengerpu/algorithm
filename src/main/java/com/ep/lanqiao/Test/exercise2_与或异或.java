package com.ep.lanqiao.Test;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-08 9:07
 */
public class exercise2_与或异或 {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 0; i < (1 << 5); i++) {
            if(check(i)){
                ans++;
            }
        }
        // System.out.println(check((1<<5) - 1));
        System.out.println(ans);
    }

    private static boolean check(int x) {
        int[] nums = new int[6];
        for (int i = 0; i < 5; i++) {
            nums[i] = x >> i & 1;
        }
        int a = nums[0] | nums[1];
        int b = nums[1] ^ nums[2];
        int c = nums[2] ^ nums[3];
        int d = nums[3] & nums[4];

        int t2 = a | b;
        int t3 = b & c;
        int t4 = c ^ d;

        int s1 = t2 | t3;
        int s2 = t3 ^ t4;

        int r = s1 | s2;
        if(r == 1){
            return true;
        }
        return false;
    }
}
