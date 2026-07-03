class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = max(weights);
        int hi = Arrays.stream(weights).boxed().reduce(0, (a, b) -> a + b);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, mid, days)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private static boolean canShip(int[] weights, int capacity, int days) {
        int load = 0;
        int daysNeeded = 1;
        for (int weight : weights) {
            if (load + weight > capacity) {
                daysNeeded++;
                load = 0;
            }
            load += weight;
        }

        return daysNeeded <= days;
    }

    private static int max(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            max = Math.max(max, weight);
        }

        return max;
    }
}