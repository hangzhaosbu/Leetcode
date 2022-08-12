class Solution {
    
    int[] nums;
    
    public int maxSubArray(int[] nums)
    {
        this.nums = nums;
        
        return divideAndConquer(0, nums.length - 1);
    }
    
    private int divideAndConquer(int left, int right)
    {
        if(left > right)
        {
            return Integer.MIN_VALUE;
        }
        
        int mid = (left + right) / 2;
        
        int sum = 0;
        int bestright = 0;
        int bestleft = 0;
        
        for(int i = mid + 1; i <= right; ++i)
        {
            sum += this.nums[i];
            bestright = Math.max(bestright, sum);
        }
        
        sum = 0;
        
        for(int i = mid - 1; i >= left; --i)
        {
            sum += this.nums[i];
            bestleft = Math.max(bestleft, sum);
        }
        
        int best = bestleft + nums[mid] + bestright;
        
        int l = divideAndConquer(left, mid - 1);
        int r = divideAndConquer(mid + 1, right);

        return Math.max(best, Math.max(l, r));
    }
}