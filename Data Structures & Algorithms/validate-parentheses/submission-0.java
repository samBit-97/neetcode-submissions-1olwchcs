class Solution {
    public boolean isValid(String s) {
        Stack<Character> seen = new Stack<>();
        Map<Character, Character> pair = Map.of(')', '(', '}', '{', ']', '[');

        for (Character c : s.toCharArray()) {
            if (!seen.isEmpty() && pair.get(c) == seen.peek()) {
                seen.pop();
            } else {
                seen.push(c);
            }
        }
        return seen.size() == 0;
    }
}
