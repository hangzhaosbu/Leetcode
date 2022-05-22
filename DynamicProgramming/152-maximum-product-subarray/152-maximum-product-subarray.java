class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;
        
        int pdp = 1;
        int ndp = 1;
        
        int result = Integer.MIN_VALUE;
        for(int i = 1; i < N + 1; ++i)
        {
            int tpdp = pdp, tndp = ndp;
            pdp = Math.max(nums[i - 1], Math.max(tpdp * nums[i - 1], tndp * nums[i - 1]));
            ndp = Math.min(nums[i - 1], Math.min(tndp * nums[i - 1], tpdp * nums[i - 1]));
            
            result = Math.max(result, Math.max(pdp, ndp));
        }
        
        return result;
    }
}