package com.ep.sort;

/***
 * @author dep
 * @version 1.0
 * 树的遍历
 */
public class TreeAndArray {

    /***
     * 先序排序
     * @param arr
     * @param i
     */
    static void preOrder(int[] arr, int i) {
        if(i >= arr.length)
            return;
        System.out.println(arr[i]); // 先输出根节点
        preOrder(arr, i * 2 + 1); // 输出左子树
        preOrder(arr,i * 2 + 2); // 输出右子树
    }

    /***
     * 先序排序
     * @param arr
     * @param i
     */
    static void inOrder(int[] arr, int i) {
        if(i >= arr.length)
            return;
        inOrder(arr, i * 2 + 1); // 输出左子树
        System.out.println(arr[i]); // 先输出根节点
        inOrder(arr,i * 2 + 2); // 输出右子树
    }

    /***
     * 后序排序
     * @param arr
     * @param i
     */
    static void afterOrder(int[] arr, int i) {
        if(i >= arr.length)
            return;
        afterOrder(arr, i * 2 + 1); // 输出左子树
        afterOrder(arr,i * 2 + 2); // 输出右子树
        System.out.println(arr[i]); // 输出根节点
    }

    public static void main(String[] args) {
        int[] arr = {78,56,34,43,1,15,2,23};
        preOrder(arr,0);
        System.out.println("===========");
        inOrder(arr,0);
        System.out.println("===========");
        afterOrder(arr,0);
    }
}
