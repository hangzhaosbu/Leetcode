class Solution {
    private int[] cal_zero_one(String s)
    {
        int N = s.length();
        int zeros = 0, ones = 0;
        
        for(int i = 0; i < N; ++i)
        {
            if(s.charAt(i) == '0')
            {
                zeros++;
            }
            else
            {
                ones++;
            }
        }
        
        return new int[]{zeros, ones};
    }
    
    private int dfs(int[][] count, int start, int N, int m, int n, int[][][] dp)
    {
        if(start == N)
        {
            return 0;
        }
        
        if(dp[m][n][start] != 0)
        {
            return dp[m][n][start];
        }
        
        int taken = -1;
        
        if(m >= count[start][0] && n >= count[start][1])
        {
            taken = dfs(count, start + 1, N, m - count[start][0], n - count[start][1], dp) + 1;
        }
        
        int not_taken = dfs(count, start + 1, N, m, n, dp);
        
        dp[m][n][start] = Math.max(taken, not_taken);
        return dp[m][n][start];
    }
    
    public int findMaxForm(String[] strs, int m, int n)
    {
        int N = strs.length;
        int[][] count = new int[N][N];
        int[][][] dp = new int[m + 1][n + 1][N];
        
        for(int i = 0; i < N; i++)
        {
            count[i] = cal_zero_one(strs[i]);
        }
        
        return dfs(count, 0, N, m, n, dp);
    }
}