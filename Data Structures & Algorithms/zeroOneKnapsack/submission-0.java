class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int N = profit.size();
        int M = capacity + 1;
        int[][] dp = new int[N][M];

        for (int c = 0; c < M; c++) {
            if (weight.get(0) <= c) {
                dp[0][c] = profit.get(0);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int skip = dp[i - 1][j];
                int include = 0;
                int remaining = j - weight.get(i);
                if (remaining >= 0) {
                    include = profit.get(i) + dp[i - 1][remaining];
                }
                dp[i][j] = Math.max(skip, include);
            }
        }


        return dp[N - 1][capacity];
 
    }
}
