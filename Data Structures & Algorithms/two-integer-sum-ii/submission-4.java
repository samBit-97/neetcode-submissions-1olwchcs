class Solution {
    public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length - 1; i++) {
            int temp = target - numbers[i];
            int begin = i + 1;
            int end = numbers.length - 1;
            while (begin <= end) {
                int mid = begin + (end - begin) / 2;
                if (temp == numbers[mid]) {
                    return new int[] {i + 1, mid + 1};
                }
                if (temp > numbers[mid]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return new int[] {};


    }
}
