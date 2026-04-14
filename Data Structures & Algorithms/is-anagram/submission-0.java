class Solution {
    public boolean isAnagram(String s, String t) {
                if (s.length() != t.length()) return false;

        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i) - 97;
            charCount[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = (int) t.charAt(i) - 97;
            charCount[index]--;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) return false;
        }

        return true;

    }
}
