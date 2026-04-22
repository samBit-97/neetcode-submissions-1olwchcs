class Solution {
    public boolean isValid(String s) {
        Stack<Character> seen = new Stack<>();
        Map<Character, Character> closingOpeningPair = Map.of(')', '(', '}', '{', ']', '[');

        for (Character c : s.toCharArray()) {
            if (closingOpeningPair.containsKey(c)) {
                if (!seen.isEmpty() && seen.peek() == closingOpeningPair.get(c)) {
                    seen.pop();
                } else {
                    return false;
                }
            } else {
                seen.push(c);
            }
        }
        return seen.size() == 0;

    }
}
