class Solution {
    public int maxProfit(int[] prices) {
        

        int n = prices.length;

        if (n <= 1) return 0;

        int[][] dp = new int[n + 1][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);

            int cash = 0;

            if (i >= 2) {
                cash = dp[i - 2][1];
            }

            dp[i][0] = Math.max(dp[i - 1][0], cash - prices[i]);

        }

        return dp[n-1][1];
    }
}
