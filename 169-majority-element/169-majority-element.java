class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; ++i)
        {
            candidate = count == 0 ? nums[i] : candidate;
            count += nums[i] == candidate ? 1 : -1;
        }
        
        return candidate;
    }
}