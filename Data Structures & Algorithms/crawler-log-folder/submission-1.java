class Solution {
    public int minOperations(String[] logs) {
    Stack<String> logStack = new Stack<>();
        for (String log : logs) {
            if (!List.of("./", "../").contains(log)) {
                logStack.push(log);
            }
            if ("../".equalsIgnoreCase(log)) {
                if (!logStack.isEmpty()) logStack.pop();
            }
        }

        return logStack.size();
    }
}