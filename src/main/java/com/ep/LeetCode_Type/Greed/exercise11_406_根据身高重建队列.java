package com.ep.LeetCode_Type.Greed;

import java.util.Arrays;
import java.util.LinkedList;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-01 9:34
 */
public class exercise11_406_根据身高重建队列 {
    public static int[][] reconstructQueue(int[][] people) {
        // people[i] = [hi, ki] 表示第i个人的身高为 hi ，前面正好有ki个身高大于或等于hi的人。
        // 按身高降序排序，身高相同按照
        Arrays.sort(people, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
//        LinkedList<int[]> queue = new LinkedList<>();
//        for (int[] p: people) {
//            queue.add(p[1], p);
//        }
//        return queue.toArray(new int[queue.size()][]);
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if (queue.size() > people[i][1]) {
                // 结果集中元素个数大于第i个人前面应有的人数时，将第i个人插入到结果集的第people[i]位置
                queue.add(people[i][1], people[i]);
            } else {
                // 结果集中元素个数小于等于第i个人前面应有的人数时，将第i个人插入到结果集的第people[i]位置
                queue.add(queue.size(), people[i]);
            }
        }
        return queue.toArray(new int[queue.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);
    }
}
