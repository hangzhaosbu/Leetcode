class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][] dp = new int[M][N];
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < M; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                
                if(i == 0)
                {
                    dp[0][j] = matrix[0][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE, j + 1 < N ? dp[i - 1][j + 1] : Integer.MAX_VALUE)) + matrix[i][j];
                }
            
                if(i == M - 1)
                {
                    result = Math.min(result, dp[i][j]);
                }
            }
        }
        
        return result;
    }
}