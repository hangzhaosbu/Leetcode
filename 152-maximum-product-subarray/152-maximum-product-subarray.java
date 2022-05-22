class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        
        int[] pdp = new int[N + 1];
        int[] ndp = new int[N + 1];
        
        pdp[0] = 1;
        ndp[0] = 1;
        
        int result = Integer.MIN_VALUE;
        for(int i = 1; i < N + 1; ++i)
        {
            pdp[i] = Math.max(nums[i - 1], Math.max(pdp[i - 1] * nums[i - 1], ndp[i - 1] * nums[i - 1]));
            ndp[i] = Math.min(nums[i - 1], Math.min(ndp[i - 1] * nums[i - 1], pdp[i - 1] * nums[i - 1]));
            
            result = Math.max(result, Math.max(pdp[i], ndp[i]));
        }
        
        return result;
    }
}