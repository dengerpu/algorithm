package com.ep.example;

/***
 * @author dep
 * @version 1.0
 * 题5:设计一个高效的求a的n次幂的算法
 */
public class exercise4 {
    public static void main(String[] args) {
        long t = System.nanoTime();
        System.out.println(pow0(2,30));
        System.out.println("时间：" + (System.nanoTime() - t));
        t = System.nanoTime();
        System.out.println(pow(2,30));
        System.out.println("时间：" + (System.nanoTime() - t));
    }
    static int pow0(int a, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res*=a;
        }
        return res;
    }
    static int pow(int a, int n) {
        if(n == 0) return 1;
        int res = a;
        int ex = 1;
        // 左移1位，相当于乘以2
        while ((ex<<1) <=n ){
            res = res*res;
            ex <<= 1;
        }
        // 查差n-ex的次方没有去乘到结果里面
        return res*pow(a, n-ex);
    }
}
