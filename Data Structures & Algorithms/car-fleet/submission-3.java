class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int l = position.length;
        List<Movement> movements = new ArrayList<>(l);
        for (int i = 0; i < l; i++) {
            movements.add(new Movement(position[i], speed[i]));
        }
        movements.sort(Comparator.comparingDouble(Movement::position).reversed());
        Stack<Double> stack = new Stack<>();

        for (Movement m : movements) {
            double time = (target - m.position()) / m.speed();
            stack.push(time);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }

    public record Movement(double position, double speed) {}
}
