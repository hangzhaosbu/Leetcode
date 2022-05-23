class Solution {
    
    boolean result = false;
    int[][] dp;
    
    private int dfs(int start, int running_sum, int sum, int[] nums)
    {
        if(dp[start][running_sum] != -1)
        {
            return dp[start][running_sum];
        }
        
        int N = nums.length;
        
        if(start == N)
        {
            return 0;
        }
        if(running_sum == sum - running_sum)
        {
            result = true;
            dp[start][running_sum] = 1;
            return 1;
        }
        
        int r = 0;
        for(int i = start; i < N; ++i)
        {
            if(dfs(i + 1, running_sum + nums[i], sum, nums) == 1)
            {
                r = 1;
                break;
            }
        }
        
        dp[start][running_sum] = r;
        return r;
    }
    
    public boolean canPartition(int[] nums)
    {
        int N = nums.length, sum = 0;
        dp = new int[N + 1][N * 100 + 1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a, -1));
        
        for(int num : nums)
        {
            sum += num;
        }
        
        dfs(0, 0, sum, nums);
        return result;
    }
}