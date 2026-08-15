class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = 1;
        int currMin = 1;
        for (int i = 0; i < nums.length; i++) {

            int temp = nums[i] * currMax;
            currMax = Math.max(Math.max(nums[i] * currMax, nums[i] * currMin), nums[i]);
            currMin = Math.min(Math.min(temp, nums[i] * currMin), nums[i]);

            res = Math.max(res, currMax);
        }
        return res;
 
    }
}
