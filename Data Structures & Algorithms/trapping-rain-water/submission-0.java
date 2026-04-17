class Solution {
    public int trap(int[] height) {
        int l = height.length;
        int[] leftMax = new int[l];
        int[] rightMax = new int[l];

        int lMax = 0;
        for (int i = 0; i < l; i++) {
            lMax = Math.max(lMax, height[i]);
            leftMax[i] = lMax;
        }

        int rMax = 0;
        for (int j = l - 1; j >= 0; j--) {
            rMax = Math.max(rMax, height[j]);
            rightMax[j] = rMax;
        }

        int res = 0;
        for (int k = 0; k < l; k++) {
            int unit = Math.min(leftMax[k], rightMax[k]) - height[k];
            if (unit > 0) {
                res += unit;
            }
        }

        return res;
 
    }
}
