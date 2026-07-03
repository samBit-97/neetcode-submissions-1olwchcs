class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0;
        int h = nums.length - 1;
        if (nums[l] < nums[h]) return nums[l];
        while (l <= h) {
            int mid = l + (h - l) / 2;
            res = Math.min(res, nums[mid]);
            if (nums[mid] >= nums[h]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        return res;
    }
}
