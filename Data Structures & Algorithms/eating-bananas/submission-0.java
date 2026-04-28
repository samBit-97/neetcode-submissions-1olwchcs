class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     	int l = 1, r = max(piles);
		int res = r;

		while (l <= r) {
			int k = l + (r - l)/2;

			long totalTime = 0;
			for (int p : piles) {
				totalTime += Math.ceil((double) p/k);
			}	

			if (totalTime <= h)  {
				res = k;
				r = k - 1;
			} else {
				l = k + 1;
			}
		}
        return res;
    }

	private int max(int[] piles) {
		int max = -1;
		for (int p : piles) {
			max = Math.max(max, p);
		}

		return max;
	}

}
