class Solution {
    public int maxSubArray(int[] nums) {
        //[-2,1,-3,4,-1,2,1,-5,4]
        //    A      |     B
        //    A' C   | D   B'
        
        int sum = 0;
        int result = Integer.MIN_VALUE;
        
        for(int num : nums)
        {
            sum += num;
            
            if(sum < num)
            {
                sum = num;
            }
            
            result = Math.max(result, sum);
        }
        
        return result;
    }
}