class Solution {
    
    public int houserob(int[] nums)
    {
        int N = nums.length;
        int[] dp = new int[N];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < N; i++)
        {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[N - 1];
    }
    
    public int rob(int[] nums) 
    {
        int N = nums.length;
        
        if(N == 1)
        {
            return nums[0];
        }
        
        if(N == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        
        return Math.max(houserob(Arrays.copyOfRange(nums, 0, nums.length - 1)), houserob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
}