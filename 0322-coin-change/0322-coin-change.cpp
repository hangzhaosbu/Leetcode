class Solution {
public:
    int dp[12 + 1][10000 + 1];
    
    int coinChange(vector<int>& coins, int amount)
    {
        memset(dp, -1, sizeof(dp));
        int ans = dfs(0, coins, amount);
        return ans == INT_MAX - 1 ? -1 : ans;
    }
    
    int dfs(int start, vector<int>& coins, int amount)
    {
        if(start >= coins.size() || amount <= 0)
        {
            if(amount == 0) return 0;
            else return INT_MAX - 1;
        }
        
        if(dp[start][amount] != -1) return dp[start][amount];
        
        int ans = -1;
        
        if(coins[start] > amount)
        {
            int takeNoCoin = 0 + dfs(start + 1, coins, amount);
            dp[start][amount] = ans = takeNoCoin;
        }
        else
        {
            int takeCoin = 1 + dfs(start, coins, amount - coins[start]);
            int takeNoCoin = 0 + dfs(start + 1, coins, amount);
            
            dp[start][amount] = ans = min(takeCoin, takeNoCoin);
        }
        
        return ans;
    }
};