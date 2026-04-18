class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] freq = new int[26];
        int matches = 0;
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int j = 0; j < 26; j++) {
            if (freq[j] == 0) {
                matches++;
            }
        }

        if (matches == 26) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            int incomingIdx = s2.charAt(i) - 'a';
            int outgoingIdx = s2.charAt(i - s1.length()) - 'a';

            // character coming into the window
            if (freq[incomingIdx] == 0) matches--;
            freq[incomingIdx]--;
            if (freq[incomingIdx] == 0) matches++;

            // character going out the window
            if (freq[outgoingIdx] == 0) matches--;
            freq[outgoingIdx]++;
            if (freq[outgoingIdx] == 0) matches++;

            // window matches 26
            if (matches == 26) return true;
        }
        return false;
 
    }
}
