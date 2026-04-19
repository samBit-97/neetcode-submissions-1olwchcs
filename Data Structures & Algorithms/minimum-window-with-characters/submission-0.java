class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int resLength = Integer.MAX_VALUE;

        for (Character c : t.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }

        int left = 0;
        int right;
        int[] resIdx = new int[] {-1, -1};
        int need = freq.size();
        int have = 0;
        for (right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            window.merge(c, 1, Integer::sum);

            if (freq.containsKey(c) && freq.get(c) == window.get(c)) have++;

            while (have == need) {
                if (right - left + 1 < resLength) {
                    resIdx = new int[] {left, right};
                    resLength = right - left + 1;
                }

                Character l = s.charAt(left);
                if (freq.containsKey(l) && window.get(l) == freq.get(l)) have--;
                window.put(l, window.get(l) - 1);
                left++;
            }
        }

        left = resIdx[0];
        right = resIdx[1];
        return (resLength != Integer.MAX_VALUE) ? s.substring(left, right + 1) : "";
 
    }
}
