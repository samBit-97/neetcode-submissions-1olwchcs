class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int cheapest = prices[0];
        int profit = 0;

        for (int price : prices) {
            int currProfit = price - cheapest;
            profit = Math.max(currProfit, profit);
            cheapest = Math.min(cheapest, price);
        }
        return profit;
    }
}
