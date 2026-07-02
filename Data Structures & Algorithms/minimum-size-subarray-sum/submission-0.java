class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int res = Integer.MAX_VALUE;
        int windowSum = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum >= target) {
                res = Math.min(res, (right - left) + 1);
                windowSum -= nums[left];
                left++;
            }
        }

        return Integer.MAX_VALUE == res ? 0 : res;
 
    }
}