class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int res = 0;
        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            res = Math.max(area, res);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
  
    }
}
