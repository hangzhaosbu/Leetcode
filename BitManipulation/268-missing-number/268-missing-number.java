class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i <= nums.length; ++i)
        {
            result ^= i;
        }
        
        for(int num : nums)
        {
            result ^= num;
        }
        
        return result;
    }
}