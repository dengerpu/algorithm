package com.ep.recursion;

/***
 * @author dep
 * @version 1.0
 * 旋转数组的最小数字（改造二分法)
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的-个旋转，该数组的最小值为1.
 */
public class exercise4 {
    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        System.out.println(min(arr));

        int arr1[] = {1,0,1,1,1};
        System.out.println(min(arr1));
    }
    static int min(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        // 考虑没有旋转这这种特殊的旋转
        if(arr[begin] < arr[end]) return arr[begin];
        if(arr[begin] == arr[end]) {
            System.out.println("应该用顺序查找");
            return -1;
        }
        // begin和end指向相邻元素，退出
        while(begin + 1 < end) {
            int mid = begin + ((end-begin) >> 1);
            // 要么左侧有序，要么右侧有序
            if(arr[mid] >= arr[begin]) { // 左侧有序
                begin = mid;
            }else {
                end = mid;
            }
        }
        return arr[end];
    }
}
