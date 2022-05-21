class Solution {
    public int coinChange(int[] coins, int M) {
        if(M == 0)
            return 0;
        int N = coins.length;
        int[][] dp = new int[N][M + 1];
        
        Arrays.stream(dp).forEach(a->Arrays.fill(a, Integer.MAX_VALUE/2));
        dp[0][0] = 0;
        
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M + 1; ++j)
            {
                if(i >= 1)
                    dp[i][j] = dp[i - 1][j];
                if(j >= coins[i])
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
            }
        }
        
        if(dp[N - 1][M] < 0 || dp[N - 1][M] > 10000)
        {
            return -1;
        }
        return dp[N - 1][M];
    }
}