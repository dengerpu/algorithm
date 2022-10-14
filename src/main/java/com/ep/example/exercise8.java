package com.ep.example;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * 归并排序
 */
public class exercise8 {
    static int[] helper;
    public static void main(String[] args) {
        int[] arr= {1,5,3,6,9,8,7,4,1};
        helper = new int[arr.length];
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void  mergeSort(int[] arr, int p, int r) {
        if( p < r ) {
           int mid = p + ((r-p) >> 1);
           mergeSort(arr,p, mid); // 左侧排序
           mergeSort(arr,mid+1, r); // 右侧排序
            merge(arr,p,mid,r); // 合并
        }
    }
    static void merge(int[] arr,int p, int mid, int r) {
        // 先把arr中的数据拷贝到helper中
        System.arraycopy(arr, p ,helper, p, r-p+1);
        int left = p; // 左侧队伍的头部指针，指向待比较的元素
        int right = mid + 1; // 右侧队伍的头部指针，指向待比较的元素
        int current = p; // 原数组的指针，指向带填入数据的位置

        while(left <= mid && right <= r) {
            if(helper[left] <= helper[right]) {
                arr[current] = helper[right];
                current++;
                left++;
            }else {
                arr[current] = helper[right];
                current++;
                right++;
            }
        }
        while(left <= mid) {
            arr[current] = helper[left];
            current++;
            left++;
        }
        while(right <= r) {
            arr[current] = helper[right];
            current++;
            right++;
        }

    }
}
