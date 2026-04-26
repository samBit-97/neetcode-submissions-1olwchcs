class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Coordinate> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {

            int start = i;
            while (!stack.isEmpty() && heights[i] < stack.peek().height()) {
                Coordinate c = stack.pop();
                maxArea = Math.max(maxArea, (i - c.position()) * c.height());
                start = c.position();
            }
            stack.push(new Coordinate(start, heights[i]));
        }

        for (Coordinate c : stack) {
            maxArea = Math.max(maxArea, (heights.length - c.position()) * c.height());
        }
        return maxArea;
    }

    public record Coordinate(int position, int height) {}
}
