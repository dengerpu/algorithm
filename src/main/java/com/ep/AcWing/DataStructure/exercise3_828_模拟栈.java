package com.ep.AcWing.DataStructure;

import java.util.Arrays;
import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-15 10:59
 */
public class exercise3_828_模拟栈 {
    static int N = 100010;
    static int[] arr = new int[N];
    static int top;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int x;
        init();
        while (m != 0) {
            String op = scanner.next();
            switch (op) {
                case "push":
                    x = scanner.nextInt();
                    push(x);
                    break;
                case "pop":
                    pop();
                    break;
                case "empty":
                    if (isEmpty()) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
                case "query":
                    System.out.println(peek());
                    break;
            }
            m--;
        }

    }

    static void init() {
        top = -1;
    }

    static void push(int x) {
        top++;
        arr[top] = x;
    }

    static int pop() {
        if (!isEmpty()) {
            return arr[top--];
        }
        return -1;
    }

    static int peek() {
        return arr[top];
    }

    static Boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}
