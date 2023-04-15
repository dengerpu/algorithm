package com.ep.AcWing.DataStructure;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-15 15:21
 */
public class exercise4_3302_表达式求值 {
     static Stack<Integer> num_stack = new Stack<>();
    static Stack<Character> op_stack = new Stack<>();
    // 运算符的优先级
    static HashMap<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < exp.length() && Character.isDigit(exp.charAt(j))) {
                    x = x * 10 + (exp.charAt(j) - '0');
                    j++;
                }
                i = j - 1;
                num_stack.push(x);
            } else if (c == '(') {
                op_stack.push(c);
            } else if( c == ')') {
                while (op_stack.peek() != '(') eval();
                op_stack.pop();
            } else {
                // 这里 map.get(op_stack.peek())，可能会取出左括号
                while (!op_stack.isEmpty() && map.getOrDefault(op_stack.peek(),0) >= map.get(c)) eval();
                op_stack.push(c);
            }
        }
        while (!op_stack.isEmpty()) eval();
        System.out.println(num_stack.pop());
    }

    // 计算
    public static void eval() {
        int b = num_stack.pop();
        int a = num_stack.pop();
        char op = op_stack.pop();
        switch (op) {
            case '+': num_stack.push(a+b);break;
            case '-': num_stack.push(a-b);break;
            case '*': num_stack.push(a*b);break;
            case '/': num_stack.push(a/b);break;
        }
    }
}
