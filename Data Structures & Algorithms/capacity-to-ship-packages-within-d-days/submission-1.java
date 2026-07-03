class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = max(weights);
        int hi = Arrays.stream(weights).boxed().reduce(0, (a, b) -> a + b);
        int res = hi;
        // System.out.println(lo + " " + hi);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, mid, days)) {
                res = Math.min(res, mid);
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }

    private boolean canShip(int[] weights, int capacity, int days) {
        int daysNeeded = 1;
        int load = 0;
        for (int weight : weights) {
            if (load + weight > capacity) {
                daysNeeded++;
                load = 0;
            }
            load += weight;
        }

        return daysNeeded <= days;
    }

    private int max(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            max = Math.max(max, weight);
        }

        return max;
    }
}