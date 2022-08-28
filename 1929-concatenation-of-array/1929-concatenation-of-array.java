class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        
        for(int i = 0; i < nums.length * 2; ++i)
            
        {
            result[i] = nums[i%nums.length];
        }
        
        return result;
    }
}