class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int count = 1;
        
        for(int i = 1; i <= n ; ++i)
        {
            if(i == count * 2)
            {
                count *= 2;
            }
            
            dp[i] = dp[i - count] + 1;
        }
        
        return dp;
    }
}