class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) {
            return -1;
        }

        int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
        };

        boolean visit[][] = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        visit[0][0] = true;
        q.add(new int[] {0, 0});

        int length = 1;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                int[] pair = q.poll();
                int r = pair[0], c = pair[1];

                if (r == N - 1 && c == N - 1) {
                    return length;
                }

                for (int[] d : DIRECTIONS) {
                    int newR = r + d[0], newC = c + d[1];

                    if (newR < 0
                            || newR == N
                            || newC < 0
                            || newC == N
                            || visit[newR][newC]
                            || grid[newR][newC] == 1) {
                        continue;
                    }

                    visit[newR][newC] = true;
                    q.add(new int[] {newR, newC});
                }
            }
            length++;
        }

        return -1;
 
    }
}