class Solution {
    public int maxSubArray(int[] nums)
    {
        int running_sum = 0, result = Integer.MIN_VALUE;
        
        for(int num : nums)
        {
            running_sum = running_sum + num < num ? num : running_sum + num;
            result = Math.max(result, running_sum);
        }
        
        return result;
    }
}