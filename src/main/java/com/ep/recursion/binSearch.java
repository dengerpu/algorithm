package com.ep.recursion;

/***
 * @author dep
 * @version 1.0
 * 折半查找递归
 */
public class binSearch {
    public static void main(String[] args) {
        int[] arr = {1,5,6,8,9,12,15,16};
        System.out.println(binSearch(arr, 0, arr.length - 1, 5));
    }

    static int binSearch( int[] arr, int low, int high, int key) {
        if( low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1); // 右移一位相当于除以2
        int midVal = arr[mid];
        if(midVal < key) {
            return binSearch(arr, mid+1, high, key);
        } else if(midVal > key) {
            return binSearch(arr, low, mid-1,key);
        } else
            return mid;
    }

}
