package com.ep.AcWing.DataStructure;

import java.util.Arrays;
import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-10 9:53
 */
public class exercise1_826_单链表 {
    static int N = 100010;
    static int[] e = new int[N]; // e[i]表示结点i的值
    static int[] ne = new int[N]; // ne[i]表示结点i的next指针是多少
    static int head;// head表示头结点的下标
    static int idx;// idx 存储当前已经用到了哪个点

    public static void main(String[] args) {
        // 为什么要用数组模拟链表（new 每次的开销很大）
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int k, x;
        init();
        while (m != 0) {
            Character ch = scanner.next().toCharArray()[0];
            switch (ch) {
                case 'H':
                    x = scanner.nextInt();
                    add_to_head(x);
                    break;
                case 'D':
                    k = scanner.nextInt();
                    if (k == 0) {
                        head = ne[head];
                    } else {
                        remove(k - 1);
                    }
                    break;
                case 'I':
                    k = scanner.nextInt();
                    x = scanner.nextInt();
                    add(k - 1, x);
                    break;
            }
            m--;
        }
        print();
    }

    static void init() {
        head = -1;
        idx = 0;
    }

    // 将x插入头结点
    static void add_to_head(int x) {
        e[idx] = x; // 相当于new了一个新的结点
        ne[idx] = head; // 新结点指向head的下一个结点
        head = idx;
        idx++;
    }

    // 将x插到下标是k的节点的后面
    static void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    // 将下标是k的点后面的点删掉
    static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    static void print() {
        int p = head;
        while (p != -1) {
            System.out.print(e[p] + " ");
            p = ne[p];
        }
    }

}
