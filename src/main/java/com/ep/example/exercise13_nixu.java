package com.ep.example;

/***
 * @author dep
 * @version 1.0
 */

import org.assertj.core.api.Assertions;
import org.lanqiao.algo.util.Util;

/**
 * 思路：将数组分为左右两个子数组，递归调用归并进行排序
 *      分别排序完成后，使用辅助的合并函数将两个有序的子数组合并成一个整体有序的数组
 * 时间复杂度：均：O(nlgn)，好：O(nlgn)，坏：O(nlgn)
 * 空间复杂度：需要开辟辅助空间，该辅助空间可以重用，大小为N
 * 非原址排序
 * 稳定性：所有排序都是归并，在左的永远在左，在右的永远在右，稳定
 */
public class exercise13_nixu {
    private static int[] helper;

    public static void sort(int[] arr) {
        helper = new int[arr.length];
        sort(arr, 0, arr.length -1);
    }

    /***
     * 分两段进行排序，然后再合并
     * @param A
     * @param p
     * @param r
     */
    private static void sort(int[] A, int p, int r) {
        if(p < r ){
            int mid = p + ((r - p) >> 1); // 中位数
            sort(A, p, mid); // 左侧排序
            sort(A, mid+1, r); // 右侧排序
            /**
             * 合并的过程中只要抓右侧的数据就有逆序对，因为左侧右侧都是排序好的，
             * 只需要抓左侧，逆序对的个数就是左侧剩余的元素
             */
            merge(A,p,mid,r); // 合并
        }
    }
    static int  niXu = 0;

    /**
     * 假设数组的两段分别有序，借助一个辅助数组来缓存原数组，用归并的思路将元素从辅助数组中拷贝回原数组
     * @param A 原数组
     * @param p 低位
     * @param mid 中间位
     * @param r 高位
     */
    private static void merge(int[] A,int p, int mid, int r) {
        // 拷贝到辅助空间相同的位置
        System.arraycopy(A,p,helper,p, r-p +1);
        // 辅助数组的两个指针
        int left = p, right = mid +1;
        // 原始数组的指针
        int current = p;
        while (left <= mid && right <= r) {
            if(helper[left] <= helper[right]) {
                A[current++] = helper[left++];
            } else { // 右侧小
                A[current++] = helper[right++];
                niXu += mid - left + 1;
            }
        }
        while (left <= mid) {
            A[current] = helper[left];
            current++;
            left++;
        }
    }
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(10, 1, 100);
        Util.print(arr);
        sort(arr);
        Util.print(arr);
        Assertions.assertThat(Util.checkOrdered(arr, true)).isTrue();
        System.out.println("nixu:" + niXu);
    }
}
