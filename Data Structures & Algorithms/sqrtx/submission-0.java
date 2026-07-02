class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int h = x;
        int res = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            long square = (long) mid * mid;
            if (square == x) return mid;
            else if (square > x) {
                h = mid - 1;
            } else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
 
    }
}