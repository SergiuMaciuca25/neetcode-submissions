class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;

        int[][] dp = new int[n + 1][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        int max = nums[0];

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            int option1 = dp[i - 1][0] * nums[i];
            int option2 = dp[i - 1][1] * nums[i];
            int option3 = nums[i];

            dp[i][0] = Math.max(option1, Math.max(option2, option3));
            dp[i][1] = Math.min(option1, Math.min(option2, option3));
            
            max = Math.max(max, dp[i][0]);

        }

        return max;
        
    }
}

