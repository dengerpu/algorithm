package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-10 10:48
 */
public class exercise661_图片平滑器 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] results = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int x = i-1; x <= i+1; x++) {
                    for (int y = j-1; y <= j+1; y++) {
                        if (x >=0 && x < m && y >=0 && y < n ) {
                            sum+=img[x][y];
                            count++;
                        }
                    }
                }
                results[i][j] = sum / count;
            }
        }
        return results;
    }
}
