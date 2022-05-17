class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] new_cost = new int[N + 2];
        
        for(int i = 0; i < N; i++)
        {
            new_cost[i + 2] = cost[i];
        }
        
        int[] dp = new int[N + 3];
        
        for(int i = 2; i < N + 3; i++)
        {
            dp[i] = Math.min(i < N + 2 ? dp[i - 1] + new_cost[i] : dp[i - 1], i < N + 2 ? dp[i - 2] + new_cost[i] : dp[i - 2]);
        }
        
        return dp[N + 2];
    }
}