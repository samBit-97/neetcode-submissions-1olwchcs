class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroup = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sortedStr = new String(c);
            anagramGroup.putIfAbsent(sortedStr, new ArrayList<>());
            anagramGroup.get(sortedStr).add(strs[i]);
        }

        return new ArrayList<>(anagramGroup.values());
    }
}
