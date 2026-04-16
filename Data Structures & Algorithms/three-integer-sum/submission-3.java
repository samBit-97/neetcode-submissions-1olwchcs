class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i - 1]) {
                continue;
            }

            int begin = i + 1;
            int end = length - 1;
            while (begin < end) {
                int target = a + nums[begin] + nums[end];

                if (target > 0) {
                    end--;
                } else if (target < 0) {
                    begin++;
                } else {
                    res.add(Arrays.asList(a, nums[begin], nums[end]));
                    begin++;
                    end--;
                    while (begin < end && nums[begin] == nums[begin - 1]) {
                        begin++;
                    }
                    while (begin < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
            }
        }

        return res;
    }
}
