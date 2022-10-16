package com.ep.example;

/***
 * @author dep
 * @version 1.0
 * 以尽量高的效率求出一个乱序数组中按数值顺序的第K个元素值
 */
public class exercise10 {
    public static void main(String[] args) {
        int[] arr = {1,3,6,5,8,9,4,2,5,7};
        System.out.println(selectK(arr, 0, arr.length - 1, 1));
        System.out.println(selectK(arr, 0, arr.length - 1, 3));
        System.out.println(selectK(arr, 0, arr.length - 1, 5));
        System.out.println(selectK(arr, 0, arr.length - 1, 7));
        System.out.println(selectK(arr, 0, arr.length - 1, arr.length));
    }

    /***
     * 查找第k个元素
     * @param arr
     * @param p
     * @param r
     * @param k
     * @return
     */
    static int selectK(int[] arr, int p, int r, int k) {
        int q = partition(arr,p,r);
        int qk = q-p+1; // 主元是第几个元素
        if( qk == k) {
            return arr[q];
        }else if( qk > k) {
            return selectK(arr, p, q-1, k);
        } else {
            // 右侧查找的应该是第k-qk个
            return selectK(arr, q+1, r, k - qk);
        }
    }
    /**
     * 确定中间的元素的位置
     * @param arr
     * @param p
     * @param r
     * @return
     */
    static int partition(int[] arr, int p, int r) {
        int pivot = arr[p];
        int left = p + 1;
        int right = r;
        while( left <= right ) {
            if(left <= right && arr[left] <= pivot) left++;
            if(left <= right && arr[right] > pivot) right--;
            if(left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr,p,right);
        return right;
    }

    /***
     * 交换元素
     * @param arr
     * @param m
     * @param n
     */
    static void swap(int[] arr, int m, int n) {
        int t = arr[m];
        arr[m] = arr[n];
        arr[n] = t;
    }
}
