class Solution {
    public int coinChange(int[] coins, int amount) {


      int[] dp = new int[amount + 1];

      for (int i = 0; i <= amount; i++) {
        dp[i] = amount + 1;
      }  

      dp[0] = 0;

      for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {

        for (int coin : coins) {

            if (coin <= currentAmount) {

                int remaining = currentAmount - coin;

                int candidate = dp[remaining] + 1;

                if (candidate < dp[currentAmount]) {
                    dp[currentAmount] = candidate;
                }
            }

        }

      }

      if (dp[amount] > amount) {
            return -1;
        }

        // Otherwise, dp[amount] holds the true minimum number of coins.
        return dp[amount];
    }
}



