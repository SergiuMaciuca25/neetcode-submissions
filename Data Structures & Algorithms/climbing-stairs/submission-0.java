class Solution {
    public int climbStairs(int n) {
        
        int x = 1;
        int y = 1;

        if (n <= 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            int aux = y;
            y = y + x;

            x = aux;
        }

        return y;
    }
}
