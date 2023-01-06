package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-05 12:17
 */
public class exercise463_岛屿的周长 {
    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    count +=4;
                    // 判断左边有没有盒子
                    if (j >= 1 && grid[i][j-1] == 1) {
                        count -= 1;
                    }
                    // 判断右边有没有盒子
                    if (j < grid[i].length - 1 && grid[i][j+1] == 1) {
                        count -= 1;
                    }
                    // 判断上边有没有盒子
                    if ( i >= 1 && grid[i-1][j] == 1) {
                        count -= 1;
                    }
                    // 判断下边有没有盒子
                    if (i < grid.length - 1 && grid[i+1][j] == 1) {
                        count -= 1;
                    }
                }
            }
        }
        return count;
    }

    // 答案解法一:
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    //两个竖起来相加，  分别是下边，右边，左边，上边

    public int islandPerimeter2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        // tx < 0,代表是最左边的，tx >= n 最右边
                        // ty < 0,代表最上边，ty >= m 代表最下边
                        if (tx < 0 || tx >=n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }

    // 答案解法二：深度优先搜索
    public int islandPerimeter3(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n ,m);
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, int n, int m){
        if ( x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx,ty,grid,n,m);
        }
        return res;
    }


    public static void main(String[] args) {
        // int [][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int [][] grid = {{1,0}};
        System.out.println(islandPerimeter(grid));
    }
}
