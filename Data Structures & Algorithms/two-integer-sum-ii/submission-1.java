class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int begin = 0;
        int end = numbers.length - 1;
        while (begin < end) {
            int diff = target - numbers[begin];
            if (diff == numbers[end]) {
                return new int[] {begin + 1, end + 1};
            }
            if (diff < numbers[end]) {
                end--;
            } else {
                begin++;
            }
        }

        return new int[] {};
    }
}
