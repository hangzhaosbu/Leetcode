class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, result = Integer.MIN_VALUE;
        
        for(int num : nums)
        {
            sum = Math.max(sum + num, num);
            result = Math.max(sum, result);
        }
        
        return result;
    }
}