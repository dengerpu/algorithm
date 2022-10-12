package com.ep.example;

import java.sql.Array;
import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * 最长连续递增子序列（部分有序）
 * (1,9,2,5,7,3,4,6,8,0)中最长的递增子序列为(3,4,6,8)。
 */
public class exercise3 {
    public static void main(String[] args) {
        int arr[] = {1,9,2,5,7,3,4,6,8,0};
        int res[] = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
          if(arr[i] < arr[i+1]) {
            max ++ ;
          } else {
              res[i] = max;
              max = 0;
          }
          if(i + 1 == arr.length - 1) {
              res[i+1] = max;
          }
        }
//        System.out.println(Arrays.toString(res));
        int maxVal = 0;
        int indexOf = 0;
        for (int i = 0; i < res.length; i++) {
            if(res[i] >= maxVal) {
                maxVal = res[i];
                indexOf = i;
            }
        }
        int result[] = new  int[maxVal + 1];
        System.arraycopy(arr,indexOf - maxVal, result, 0, maxVal + 1);
        System.out.println(Arrays.toString(result));

    }
}
