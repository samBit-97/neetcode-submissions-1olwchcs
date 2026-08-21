class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orig = image[sr][sc];
        if (orig == color) {
            return image;
        }
        int N = image.length;
        int M = image[0].length;

        dfs(image, sr, sc, orig, color, N, M);
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int orig, int color, int N, int M) {
        if (r < 0 || r == N || c < 0 || c == M || image[r][c] != orig) {
            return;
        }

        image[r][c] = color;
        dfs(image, r + 1, c, orig, color, N, M);
        dfs(image, r - 1, c, orig, color, N, M);
        dfs(image, r, c + 1, orig, color, N, M);
        dfs(image, r, c - 1, orig, color, N, M);
    }
}