class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        
        int leftMax = nums[0];
        for(int i = 1; i < n - 1; i++)
        {
            left_max[i] = leftMax;
            leftMax = Math.max(leftMax, nums[i]);
        }
        
        int rightMax = nums[n - 1];
        for(int i = n - 1; i >= 1; i--)
        {
            right_max[i] = rightMax;
            rightMax = Math.max(rightMax, nums[i]);
        }
        
        for(int i = 0; i < n; i++)
        {
            ans = Math.max(ans, ((long) left_max[i] - nums[i]) * (long) right_max[i]);
        }
        
        return ans;
    }
}