class Solution {
    public int maxSubArray(int[] nums)
    {
        int sum = 0, result = Integer.MIN_VALUE;
        
        for(int num : nums)
        {
            sum+=num;
            
            if(sum < num)
            {
                sum = num;
            }
            
            result = Math.max(result, sum);
        }
        
        return result;
    }
}