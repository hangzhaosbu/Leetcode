class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        
        for(int i = 0; i <= Math.min(max, nums.length - 1); ++i)
        {
            max = Math.max(max, i + nums[i]);
        }
        
        return max >= nums.length - 1;
    }
}