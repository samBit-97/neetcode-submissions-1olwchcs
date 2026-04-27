class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = matrix[mid / cols][mid % cols];
            if (val == target) return true;
            if (val > target) end = mid - 1;
            else start = mid + 1;
        }

        return false;
 
    }
}
