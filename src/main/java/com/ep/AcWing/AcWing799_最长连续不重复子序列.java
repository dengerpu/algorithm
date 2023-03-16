package com.ep.AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-16 15:10
 */
public class AcWing799_最长连续不重复子序列 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s);
        int[] arr = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        String[] s1 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        int max = 0;
        for (int i = 0,j = 0; i < n; i++) {
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0) + 1);
            while (hashMap.getOrDefault(arr[i],0) > 1) {
                hashMap.put(arr[j],hashMap.getOrDefault(arr[j], 0) - 1);
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        System.out.println(max);
    }
}
