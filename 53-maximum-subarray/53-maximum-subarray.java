class Solution {
    public int maxSubArray(int[] nums)
    {
        return divideAndConquer(0, nums.length - 1, nums);
    }
    
    private int divideAndConquer(int left, int right, int[] nums)
    {
        if(left > right) return Integer.MIN_VALUE;
        
        int mid_pos = (right - left) / 2 + left;
        int mid_val = nums[mid_pos];
        int sum = 0;
        int max_left = 0, max_right = 0;
        
        for(int i = mid_pos - 1; i >= left; --i)
        {
            sum += nums[i];
            max_left = Math.max(max_left, sum);
        }
        
        sum = 0;
        
        for(int i = mid_pos + 1; i <= right; ++i)
        {
            sum += nums[i];
            max_right = Math.max(max_right, sum);
        }
        
        int left_best = divideAndConquer(left, mid_pos - 1, nums);
        int right_best = divideAndConquer(mid_pos + 1, right, nums);
        
        return Math.max(max_left + max_right + mid_val, Math.max(left_best, right_best));
    }
}