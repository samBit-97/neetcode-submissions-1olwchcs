class Solution {
    static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int island = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    island++;
                }
            }
        }

        return island;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
