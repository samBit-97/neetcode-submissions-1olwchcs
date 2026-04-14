class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indexMap.containsKey(diff)) {
                res[1] = i;
                res[0] = indexMap.get(diff);
                break;
            }
            indexMap.put(nums[i], i);
        }
        return res;
 
    }
}
