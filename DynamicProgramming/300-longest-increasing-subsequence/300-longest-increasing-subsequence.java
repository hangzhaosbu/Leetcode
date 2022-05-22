class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int result = 1;
        
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < N - 1; ++i)
        {
            for(int j = i + 1; j < N; ++j)
            {
                if(nums[j] > nums[i])
                {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
                
                result = Math.max(result, dp[j]);
            }
        }
        
        return result;
    }
}