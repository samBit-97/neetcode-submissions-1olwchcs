class Solution {
    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int area = 1;
        for (int[] dir : directions) {
            area += dfs(grid, r + dir[0], c + dir[1]);
        }

        return area;
    }
}
