class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        /*
        [1,2,3,4]
        [1,1,2,6]
        [24,12,4,1]
        */
        
        int N = nums.length;
        
        int[] result = new int[N];
        int prev = 1;
        
        for(int i = 0; i < N; ++i)
        {
            result[i] = prev;
            prev *= nums[i];
        }
        
        prev = 1;
        
        for(int i = N - 1; i > -1; --i)
        {
            result[i] *= prev;
            prev *= nums[i];
        }
        
        return result;
    }
}