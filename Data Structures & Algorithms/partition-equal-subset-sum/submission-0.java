class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true; // can make sum 0 by not selecting any element
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true; // First row only nums[0] on table
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                boolean exclude = dp[i - 1][j];
                boolean include = j - nums[i] >= 0 && dp[i - 1][j - nums[i]];
                dp[i][j] = exclude || include;
            }
        }

        return dp[nums.length - 1][target];
 
    }
}
