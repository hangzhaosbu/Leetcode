class Solution {
    int[][] dp = new int[3000][1001];
    int M = 1000000007;
    
    public int numberOfWays(int startPos, int endPos, int k)
    {
        for(int[] rows : dp)
        {
            Arrays.fill(rows, - 1);
        }
        
        return recursion(startPos, endPos, k);
    }
    
    private int recursion(int startPos, int endPos, int k)
    {
        if(k == 0)
        {
            if(startPos == endPos)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        
        if(dp[startPos + 1000][k] != -1)
        {
            return dp[startPos + 1000][k];
        }
        
        
        int left = recursion(startPos + 1, endPos, k - 1);
        int right = recursion(startPos - 1, endPos, k - 1);
        
        dp[startPos + 1000][k] = (left + right) % M;
        return dp[startPos + 1000][k];
    }
}