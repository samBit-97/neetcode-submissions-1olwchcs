class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        Set<Character> seen = new HashSet<>();
        int r = 0;
        int res = 0;

        for (r = 0; r < s.length(); r++) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
