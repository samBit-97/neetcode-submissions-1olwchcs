class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProductArr = new int[nums.length];
        int[] rightProductArr = new int[nums.length];

        int currLeft = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProductArr[i] = currLeft;
            currLeft = nums[i] * currLeft;
        }

        int currRight = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightProductArr[i] = currRight;
            currRight = nums[i] * currRight;
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = leftProductArr[i] * rightProductArr[i];
        }
        return res;
 
    }
}  
