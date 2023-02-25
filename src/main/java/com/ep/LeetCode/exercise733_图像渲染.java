package com.ep.LeetCode;

import java.util.LinkedList;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-25 9:53
 */
public class exercise733_图像渲染 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    // 广度优先搜索
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        if (currentColor == color) {
            return image;
        }
        int n = image.length, m = image[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currentColor) {
                    queue.offer(new int[]{mx,my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }

    // 深度优先搜索
    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        if (currentColor != color) {
            dfs(image, sr, sc, currentColor, color);
        }
        return image;
    }
    public void dfs(int[][] image, int x, int y,int currentColor, int color) {
        if (image[x][y] == currentColor) {
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image,mx,my,currentColor,color);
                }
            }
        }
    }
}
