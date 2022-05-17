class Solution {
    public int minPathSum(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        
        int[][] dp = new int[M][N];
        Arrays.stream(dp).forEach(a->Arrays.fill(a, Integer.MAX_VALUE));
        dp[0][0] = grid[0][0];
        
        for(int i = 0; i < M; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                
                if(i == 0 && j > 0)
                {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i][j]);
                }
                
                else if(j == 0 && i > 0)
                {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                }
                
                else if(i > 0 && j > 0)
                {
                    dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]);
                }
                
            }
        }
        
        return dp[M - 1][N - 1];
    }
}