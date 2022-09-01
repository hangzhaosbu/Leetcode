class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, result = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; ++i)
        {
            sum = Math.max(nums[i], sum + nums[i]);
            result = Math.max(result, sum);
        }
        
        return result;
    }
}