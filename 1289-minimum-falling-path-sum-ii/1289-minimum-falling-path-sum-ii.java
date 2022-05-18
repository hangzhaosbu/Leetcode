class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][] dp = new int[M][N];
        int result = Integer.MAX_VALUE;
        
        Arrays.stream(dp).forEach(a->Arrays.fill(a, Integer.MAX_VALUE));
        
        for(int i = 0; i < M; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                for(int k = 0; k < N; ++k)
                {
                    if(i == 0)
                    {
                        dp[0][j] = matrix[0][j];
                    }
                    else
                    {
                        if(j == k)
                        {
                            continue;
                        }
                        
                        dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][k], dp[i - 1][k]) + matrix[i][j]);
                    }

                    if(i == M - 1)
                    {
                        result = Math.min(result, dp[i][j]);
                    }
                }
            }
        }
        
        return result;
    }
}