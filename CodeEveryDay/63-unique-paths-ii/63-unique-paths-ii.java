class Solution {
    public int uniquePathsWithObstacles(int[][] A) {
        int M = A.length, N = A[0].length;
        int[][] dp = new int[M][N];
        
        dp[0][0] = A[0][0] == 0 ? 1 : 0;
        
        for(int i = 0; i < M; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                
                if(i == 0 && j == 0)
                {
                    continue;
                }
                
                if(A[i][j] != 1)
                {
                    dp[i][j] = (i - 1 >= 0 && A[i - 1][j] != 1 ? dp[i - 1][j] : 0) + (j - 1 >= 0 && A[i][j - 1] != 1 ? dp[i][j - 1] : 0);
                }
            }
        }
        
        return dp[M - 1][N - 1];
    }
}