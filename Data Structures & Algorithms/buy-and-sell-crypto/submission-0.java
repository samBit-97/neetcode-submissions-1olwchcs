class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int maxProfit = 0;

        while (i < prices.length - 1) {
            if (prices[i] > prices[i + 1]) {
                i++;
                continue;
            } else {
                int j = i + 1;
                while (j < prices.length && prices[j] > prices[i]) {
                    maxProfit = Math.max(prices[j] - prices[i], maxProfit);
                    j++;
                }
                i = j;
            }
        }
        return maxProfit;
 
    }
}
