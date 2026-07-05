class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Arrays.stream(nums).boxed().max(Comparator.comparing(n -> n)).get();
        int r = Arrays.stream(nums).boxed().reduce(0, (a, b) -> a + b);
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canSplit(nums, mid, k)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    private boolean canSplit(int[] nums, int mid, int k) {
        int subArray = 1;
        int subSum = 0;

        for (int num : nums) {
            if (subSum + num > mid) {
                subArray++;
                subSum = 0;
            }
            subSum += num;
        }

        return subArray <= k;
    }
}