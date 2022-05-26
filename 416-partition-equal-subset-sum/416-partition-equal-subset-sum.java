class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        
        if((sum & 1) == 1)
        {
            return false;
        }
        
        
        boolean[] dp = new boolean[sum/2 + 1];
        dp[0] = true;
        
        for(int num : nums)
        {
            
            boolean[] new_dp = dp.clone();
            
            for(int i = num; i <= sum/2; i++)
            {
                if(new_dp[i - num])
                {
                    dp[i] = true;
                }
            }
        }
        
        return dp[sum/2];
    }
}