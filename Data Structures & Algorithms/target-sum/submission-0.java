class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;

        int total = 0;

        for (int x : nums) {
            total += x;
        }

        if (Math.abs(target) > total) 
            return 0;

        int[][] dp = new int[n + 1][2 * total + 1];

        dp[0][total] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j<= 2 * total ; j++) {

                if (j - nums[i] >= 0) {
                    dp[i + 1][j] += dp[i][j - nums[i]];

                }

                if (j + nums[i] <= 2 * total) {
                    dp[i + 1][j] += dp[i][j + nums[i]];

                }
            }
        }

        return dp[n][target + total];
    }
}
