package com.ep.AcWing;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-19 10:56
 */
public class AcWing802_区间和 {
    static int N = 300010;
    static int[] a = new int[N];
    static int[] s = new int[N];
    static HashSet<Integer> hashSet = new HashSet<>();
    static int[] alls; // 存储坐标
    static int[][] adds;
    static int[][] query;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        adds = new int[n][2]; // 记录需要加的坐标和对应值
        query = new int[m][2]; // 记录需要查询的左右区间坐标
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int c = scanner.nextInt();
            hashSet.add(x);
            adds[i][0] = x;
            adds[i][1] = c;
        }
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            hashSet.add(l);
            hashSet.add(r);
            query[i][0] = l;
            query[i][1] = r;
        }
        alls = hashSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(alls);

        for (int i = 0; i < adds.length; i++) {
            int x = find(adds[i][0]);
            a[x] += adds[i][1];
        }
        for (int i = 1; i <= alls.length ; i++) {
            s[i] = s[i-1] + a[i];
        }
        for (int i = 0; i < query.length; i++) {
            int l = find(query[i][0]), r = find(query[i][1]);
            System.out.println(s[r] - s[l - 1]);
        }

    }
    // 因为对坐标进行了排序，所以需要找到这些坐标的新位置
    static int find(int x) {
        int l = 0, r = alls.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (alls[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return l + 1;
    }
}
