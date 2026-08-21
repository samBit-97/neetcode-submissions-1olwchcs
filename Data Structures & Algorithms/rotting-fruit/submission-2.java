class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int N = grid.length;
        int M = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int pair[] = q.poll();
                for (int[] d : dirs) {
                    int nr = pair[0] + d[0], nc = pair[1] + d[1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[] {nr, nc});
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

}
