class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int k = 0; k < s.length(); k++) {
            // odd length
            int i = k;
            int j = k;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                res++;
                i--;
                j++;
            }

            // even length
            i = k;
            j = k + 1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                res++;
                i--;
                j++;
            }
        }
        return res;
    }
}
