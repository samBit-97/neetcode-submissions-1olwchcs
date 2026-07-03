class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     	int l = 1, r = max(piles);
        int res = r;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canFinish(piles, mid, h)) {
                r = mid;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int totalTime = 0;
        for (int pile : piles) {
            totalTime += Math.ceilDiv(pile, speed);
        }

        return totalTime <= h;
    }

    private int max(int[] piles) {
        int max = -1;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        return max;
    }
}
