package com.ep.AcWing.DataStructure;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-11 12:30
 */
public class exercise2_827_双链表 {
    static int N = 20;
    static int[] e = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int idx, head, tail;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int k, x;
        init();
        while (m != 0) {
            String ch = scanner.next();
            switch (ch) {
                case "L":
                    x = scanner.nextInt();
                    add(head, x);
                    break;
                case "R":
                    x = scanner.nextInt();
                    add(l[tail], x);
                    break;
                case "D":
                    k = scanner.nextInt();
                    remove(k + 1);
                    break;
                case "IL":
                    k = scanner.nextInt();
                    x = scanner.nextInt();
                    add(l[k + 1], x);
                    break;
                case "IR":
                    k = scanner.nextInt();
                    x = scanner.nextInt();
                    add(k + 1, x);
                    break;
            }
            m--;
        }
        print();
    }

    // 初始化双链表
    static void init() {
        // 0表示左端点，1表示右端点
        head = 0;
        tail = 1;
        r[head] = 1;
        l[tail] = 0;
        idx = 2;
    }

    // 在下标是k的点的右边插入x
    static void add(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    // 删除第k个结点
    static void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    static void print() {
        for (int i = r[head]; i != tail; i = r[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
