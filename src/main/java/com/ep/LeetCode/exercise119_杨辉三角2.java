package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-25 10:32
 */
public class exercise119_杨辉三角2 {
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        if (rowIndex == 0) {
            list.add(1);
        }else if (rowIndex == 1) {
            list.add(1);
            list.add(1);
        } else {
            queue.offer(1);
            queue.offer(1);
            for (int i = 2; i < rowIndex +1 ; i++) {
                queue.offer(1);
                for (int j = 0; j <= i-2; j++) {
                    int a = queue.poll();
                    int b = queue.peek();
                    queue.offer(a+b);
                }
                queue.poll();
                queue.offer(1);
            }
        }
        list.addAll(queue);
        return list;
    }
    
    // 答案方法1
    // 采取获取全部行杨辉三角的形式
    // 优化1  设置一个列表来保存前一行数据
    // 优化2
    public static List<Integer> getRow2(int rowIndex) {
        // List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                if (j ==0 || j== i) {
                    list.add(1);
                } else {
                    list.add(pre.get(j-1) +pre.get(j));
                }
            }
            pre = list;
            // lists.add(list);
        }
       //  return lists.get(rowIndex);
        return pre;
    }
    // 进一步优化，只用一个数组
    public List<Integer> getRow3(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <=rowIndex ; i++) {
            row.add(0);
            for (int j = i; j > 0 ; j--) {
                row.set(j, row.get(j) + row.get(j-1));
            }
        }
        return row;
    }

    // 官方解法二
    public List<Integer> getRow4(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i < rowIndex; i++) {
            row.add((int) ((long) row.get(i-1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(5);
        System.out.println(row.toString());
        System.out.println("==========");
        System.out.println(getRow2(5).toString());
    }
}
