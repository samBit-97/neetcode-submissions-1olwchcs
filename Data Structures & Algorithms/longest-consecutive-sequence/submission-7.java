class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> input = new HashSet<>();
        int res = 0;

        for (int n : nums) {
            input.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!input.contains(nums[i] - 1)) {
                int length = 0;
                while (input.contains(nums[i] + length)) {
                    length++;
                }
                res = Math.max(length, res);
            }
        }

        return res;
    }
}
