class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right;
        Map<Character, Integer> freq = new HashMap<>();
        int res = 0;
        int maxFreq = 0;

        for (right = 0; right < s.length(); right++) {
            freq.merge(s.charAt(right), 1, Integer::sum);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(right)));

            while ((right - left + 1) - maxFreq > k) {
                freq.computeIfPresent(s.charAt(left), (key, value) -> value - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
