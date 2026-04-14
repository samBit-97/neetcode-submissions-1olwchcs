class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indexMap.containsKey(diff)) {
                return new int[] {indexMap.get(diff), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[] {};
    }
}
