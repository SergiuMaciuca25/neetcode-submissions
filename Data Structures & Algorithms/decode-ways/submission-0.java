class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            char lastChar = s.charAt(i - 1);

            if (lastChar != '0') {
                dp[i] = dp[i] + dp[i - 1];
            }


            if (i >= 2) {
                String lastTwo = s.substring(i - 2, i);

                int sum =   Integer.parseInt(lastTwo);

                if (sum >= 10 && sum <= 26) {
                    dp[i] += dp[i - 2];
                }


            }
        }


        return dp[n];
    }
}
